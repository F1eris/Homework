package figures;

public class Rectangle extends Figure {
    private double side1;
    private double side2;

    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public Rectangle(int side1, int side2, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }


    @Override
    public double calcArea() {
        return side1 * side2;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (side1 + side2);
    }
}
