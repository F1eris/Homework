import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Пустые println для отступов в консоли
        printThreeWords();
        System.out.println();

        checkSumSign();
        System.out.println();

        printColor();
        System.out.println();

        compareNumbers();
        System.out.println();

        System.out.println(method5(4, 8));
        System.out.println();

        method6(-100);
        System.out.println();

        System.out.println(method7(10));
        System.out.println();

        method8("Строка :)", 5);
        System.out.println();

        System.out.println(method9(2024));
        System.out.println();

        method10();
        System.out.println();

        method11();
        System.out.println();

        method12();
        System.out.println();

        method13();
        System.out.println();

        System.out.println(Arrays.toString(method14(15,99)));
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = 13;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 55;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 15;
        int b = 44;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean method5(int num1, int num2) {
        int sum = num1 + num2;

        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void method6(int num) {
        if (num >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean method7(int num) {
        return num < 0;
    }

    public static void method8(String str, int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(str);
        }
    }

    public static boolean method9(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    //Массивы выводятся на консоль для проверки работоспособности
    public static void method10() {
        int[] array = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void method11(){
        int[] array = new int[100];
        for(int i = 0; i < array.length; i++){
            array[i] = i+1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void method12(){
        int[] array = {1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.println(Arrays.toString(array));
        for(int i = 0; i < array.length; i++){
            if(array[i] < 6) array[i] *= 2;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void method13(){
        int[][] array = new int[10][10];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length;j++){
                if(i == j) array[i][j] = 1;
                if(i + j == array.length-1) array[i][j] = 1;
            }
        }

        //Вывод на экран
        for(int[] innerArr : array){
            System.out.println(Arrays.toString(innerArr));
        }
    }

    public static int[] method14(int len, int initialValue){
        int[] array = new int[len];

        Arrays.fill(array, initialValue);

        return array;
    }
}
