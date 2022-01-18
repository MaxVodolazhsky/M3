package task.factories;

import task.Cat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CatFactory.
 * <p>
 * Utility class
 */
public class CatFactory {

    private CatFactory() {
    }

    /**
     * Метод для создания списка кошек заданного размера.
     *
     * @param count - размер ожидаемого списка кошек.
     * @return список кошек - размера count.
     */
    public static List<Cat> makeCats(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Cat())
                .collect(Collectors.toList());
    }
}
