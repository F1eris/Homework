package figures;

public class Square extends Figure {
    private double side;

    public Square(int side) {
        this.side = side;
    }

    public Square(int side, String fillColor, String borderColor) {
        this.side = side;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calcArea() {
        return side * side;
    }

    @Override
    public double calcPerimeter() {
        return 4 * side;
    }
}
