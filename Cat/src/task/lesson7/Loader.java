package task.lesson7;

import task.model.Cat;

public class Loader {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat cat1 = new Cat(cat);

        System.out.println(cat.equals(cat1));
    }
}
