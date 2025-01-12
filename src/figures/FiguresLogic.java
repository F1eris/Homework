package figures;

public interface FiguresLogic {
    double calcPerimeter();

    double calcArea();

    String getFillColor();

    void setFillColor(String fillColor);

    String getBorderColor();

    void setBorderColor(String borderColor);

    default void showInfo() {
        System.out.println("Фигура: " + getClass().getSimpleName());
        System.out.println("Периметр: " + calcPerimeter());
        System.out.println("Площадь: " + calcArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println();
    }

}
