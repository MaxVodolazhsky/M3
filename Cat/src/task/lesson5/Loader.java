package task.lesson5;

import task.model.Cat;

public class Loader {

    public static void main(String[] args) {
        Cat kitten = getKitten();
    }

    /**
     * Добавлен в Уроке №5.
     *
     * @return сгенерированный котенок с весом 1100.
     */
    private static Cat getKitten() {
        return new Cat(1100.0);
    }
}
