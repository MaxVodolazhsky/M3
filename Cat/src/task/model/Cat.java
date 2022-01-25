package task.model;

import task.enums.CatColor;
import task.enums.CatStatus;

public class Cat {

    private static final double MAX_WEIGHT = 9000.0;
    private static final double MIN_WEIGHT = 1000.0;
    private static final int NUMBER_OF_EYES = 2;
    private static int count;

    private double originWeight;
    private double weight;
    private double foodWeight;
    private CatColor color;
    private boolean existTail;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        foodWeight = 0.0;
        count++;
    }

    /**
     * Добавлен в Уроке №5.
     * Конструктор для создание кошки с заданным весом.
     *
     * @param weight - вес кошки.
     */
    public Cat(double weight) {
        this.weight = weight;
        originWeight = weight;
        foodWeight = 0.0;
        count++;
    }

    /**
     * Добавлен в Уроке №7.
     * Конструктор для создания глубокой копии кошки.
     *
     * @param cat - объект для копирования.
     */
    public Cat(Cat cat) {
        this.originWeight = cat.originWeight;
        this.weight = cat.weight;
        this.foodWeight = cat.foodWeight;
        this.color = cat.color;
        this.existTail = cat.existTail;
        count++;
    }

    public void meow() {
        if (isDead(getStatus())) {
            System.out.println("This cat can't say \"meow\", because she's dead =(");
            return;
        }
        weight = weight - 1;
        System.out.println("Meow");
        checkDeath();
    }

    /**
     * В уроке №2 добавлено поле foodWeight и логика его увелечения.
     *
     * @param amount - количество еды.
     */
    public void feed(Double amount) {
        if (isDead(getStatus())) {
            System.out.println("This cat can't feed, because she's dead =(");
            return;
        }
        foodWeight = foodWeight + amount;
        weight = weight + amount;
        checkDeath();
    }

    /**
     * Добавлен в Уроке №2.
     * Метод чтобы кошка сходила в туалет.
     */
    public void pee() {
        if (isDead(getStatus())) {
            System.out.println("This cat can't pee, because she's dead =(");
            return;
        }
        weight = weight - 100;
        System.out.println("Cat pissing, don't interrupt!!!");
        checkDeath();
    }

    public void drink(Double amount) {
        if (isDead(getStatus())) {
            System.out.println("This cat can't drink, because she's dead =(");
            return;
        }
        weight = weight + amount;
        checkDeath();
    }

    public CatStatus getStatus() {
        if (weight < MIN_WEIGHT) {
            return CatStatus.DEAD;
        }
        if (weight > MAX_WEIGHT) {
            return CatStatus.EXPLODED;
        }
        if (weight > originWeight) {
            return CatStatus.SLEEPING;
        }
        return CatStatus.PLAYING;
    }

    private void checkDeath() {
        if (isDead(getStatus())) {
            count--;
        }
    }

    /**
     * Добавлен в Уроке №3.
     * Метод для проверки - не умерла ли кошка.
     *
     * @param status - статус кошки.
     * @return - флаг смерти.
     */
    private boolean isDead(CatStatus status) {
        return status.equals(CatStatus.DEAD) || status.equals(CatStatus.EXPLODED);
    }

    /**
     * Добавлен в Уроке №6.
     * Метод для проверки - жива ли кошка.
     *
     * @param status - статус кошки.
     * @return - флаг жизни.
     */
    public boolean isAlive(CatStatus status) {
        return !isDead(status);
    }

    public boolean hasTail() {
        return existTail;
    }

    public Double getWeight() {
        return weight;
    }

    public double getFoodWeight() {
        return foodWeight;
    }

    /**
     * Добавлен в Уроке №3.
     *
     * @return - количество живых кошек.
     */
    public static int getCount() {
        return count;
    }

    public CatColor getColor() {
        return color;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }

    public void setExistTail(boolean existTail) {
        this.existTail = existTail;
    }
}