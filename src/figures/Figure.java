package figures;

public abstract class Figure implements Perimeter, Area {
    //Пусть цвета будут просто стрингом
    protected String fillColor = "Белый";
    protected String borderColor = "Белый";


    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }
}
