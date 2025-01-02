package animals;

import misc.Bowl;

public class Cat extends Animal {
    private static int catCounter;
    //это сытость
    private boolean full;

    public Cat(String name) {
        super(name);
        maxRunDistance = 200;
        maxSwimDistance = 0;
        full = false;

        catCounter++;
    }

    public static int getCatCounter() {
        return catCounter;
    }

    public boolean isFull() {
        return full;
    }


    //Вывод в консоль для наглядности
    public void eat(Bowl bowl, int amount) {
        if (full) {
            System.out.println(name + " уже сытой");
            return;
        }

        if (bowl.getFoodAmount() >= amount) {
            //кушает
            bowl.setFoodAmount(bowl.getFoodAmount() - amount);
            System.out.printf("%s съел %d еды, в миске осталось %d еды", name, amount, bowl.getFoodAmount());
            full = true;
        } else {
            //не хватает еды в миске
            System.out.printf("%s хочет съесть %d еды, но в миске всего %d еды", name, amount, bowl.getFoodAmount());
        }
    }
}
