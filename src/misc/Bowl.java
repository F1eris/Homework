package misc;

//Класс миски с едой)
public class Bowl {
    private int foodAmount = 0;

    public Bowl(int foodAmount) {
        if (foodAmount < 0) {
            System.out.println("Ошибка: в миске не может быть отрицательное значение еды");
            return;
        }
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    //Добавить еды в миску
    public void addFoodAmount(int foodAmount) {
        this.foodAmount += foodAmount;
    }
}
