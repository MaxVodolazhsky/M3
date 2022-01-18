package task.lesson1;

import task.Cat;
import task.enums.CatStatus;
import task.factories.CatFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Loader {

    private static final double WHISKAS = 1000.0;

    public static void main(String[] args) {
        List<Cat> cats = CatFactory.makeCats(5);
        System.out.println("Print weight all cats before feed:");
        printWeightCats(cats);
        System.out.println("\nPrint weight all cats after feed:");
        feedCats(cats, 1, 2);
        System.out.println("\nKill by feeding:");
        overFeedCat(cats.get(0), 0);
        System.out.println("\nKill by meow:");
        overMeowCat(cats.get(2), 1);
    }

    /**
     * Метод для вывода массы, для каждой кошки.
     *
     * @param cats - список кошек.
     */
    private static void printWeightCats(List<Cat> cats) {
        IntStream.range(0, cats.size())
                .forEach(i -> printWeightCat(i, cats.get(i)));
    }

    /**
     * Метод для кормление кошек.
     *
     * @param cats    - список кошек.
     * @param numbers - набор номеров кошек, которых нужно накормить.
     */
    private static void feedCats(List<Cat> cats, Integer... numbers) {
        Optional<Integer> checkSize = Arrays.stream(numbers)
                .filter(i -> i > cats.size())
                .findFirst();
        if (checkSize.isPresent()) {
            System.out.printf("Number %d out of bound in list", checkSize.get());
            return;
        }
        Arrays.stream(numbers)
                .peek(i -> cats.get(i).feed(WHISKAS))
                .forEach(i -> printWeightCat(i, cats.get(i)));
    }

    /**
     * Метод чтобы закормить кошку до смерти =).
     *
     * @param cat    - кошка.
     * @param number - номер кошки.
     */
    private static void overFeedCat(Cat cat, int number) {
        while (!cat.getStatus().equals(CatStatus.EXPLODED)) {
            cat.feed(WHISKAS);
        }
        System.out.printf("Cat number %d is dead due to OVER FEED =)", number);
    }

    /**
     * Метод чтобы "замяукать" кошку до смерти =).
     *
     * @param cat    - кошка.
     * @param number - номер кошки.
     */
    private static void overMeowCat(Cat cat, int number) {
        while (!cat.getStatus().equals(CatStatus.DEAD)) {
            cat.meow();
        }
        System.out.printf("Cat number %d is dead due to OVER MEOW =)", number);
    }

    /**
     * Метод для вывода массы кошки.
     *
     * @param count - порядковый номер кошки.
     * @param cat   - кошка.
     */
    private static void printWeightCat(int count, Cat cat) {
        System.out.printf("Cat weight with number-%d = %f\n", count, cat.getWeight());
    }
}