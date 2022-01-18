package task.enums;

/**
 * Добавлен в Уроке №4.
 * Enum цвета для кошек.
 */
public enum CatColor {

    RED("красный"),
    BLACK("Черный"),
    GREY("Серый"),
    WHITE("Белый");

    private final String color;

    CatColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
