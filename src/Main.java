import animals.Animal;
import animals.Cat;
import animals.Dog;
import figures.Circle;
import figures.Figure;
import figures.Square;
import figures.Triangle;
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

        //Задание 2
        System.out.println();
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(new Circle(10, "Красный", "Зеленый"));
        figures.add(new Square(7, "Желтый", "Оранжевый"));
        figures.add(new Triangle(5, 8, 9, "Фиолетовый", "Синий"));

        for (Figure figure : figures) {
            System.out.println("Фигура: " + figure.getClass().getSimpleName());
            System.out.println("Периметр: " + figure.calcPerimeter());
            System.out.println("Площадь: " + figure.calcArea());
            System.out.println("Цвет фона: " + figure.getFillColor());
            System.out.println("Цвет границ: " + figure.getBorderColor());
            System.out.println();
        }
    }
}