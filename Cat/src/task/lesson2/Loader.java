package task.lesson2;

import task.model.Cat;

import java.util.stream.IntStream;

public class Loader {

    private static final double CAT_FOOD = 150.0;

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.feed(CAT_FOOD);
        IntStream
                .range(0, 3)
                .forEach(i -> cat.pee());
        System.out.printf("Weight food: %f", cat.getFoodWeight());
    }
}
