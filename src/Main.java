import animals.Animal;
import animals.Cat;
import animals.Dog;
import misc.Bowl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Проверка задания 1
        Dog dogBobik = new Dog("Бобик");
        Cat catBarsik = new Cat("Барсик");

        dogBobik.swim(10);
        dogBobik.run(350);

        catBarsik.swim(5000);
        catBarsik.run(250);

        //Количество созданных объектов
        System.out.println();
        System.out.println("Количество созданных животных: " + Animal.getAnimalCounter());
        System.out.println("Количество созданных собак: " + Dog.getDogCounter());
        System.out.println("Количество созданных котов: " + Cat.getCatCounter());

        //Создаем массив 10 котов
        ArrayList<Cat> cats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Cat cat = new Cat("Кот №" + i);
            cats.add(cat);
        }
        //Создаем миску с едой
        Bowl bowl = new Bowl(40);

        //Коты кушают
        System.out.println();
        for (Cat cat : cats) {
            cat.eat(bowl, (int) (Math.random() * 10 + 1));
            System.out.println();
        }

        //Итоговое состояние котов
        System.out.println();
        for (Cat cat : cats) {
            if (cat.isFull()) {
                System.out.println(cat.getName() + " сытой");
            } else {
                System.out.println(cat.getName() + " голодный");
            }
        }


    }
}