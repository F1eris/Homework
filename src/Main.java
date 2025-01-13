import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        /*Если передать массив [0][1] например, то будет ArrayIndexOutOfBoundsException
        Не знаю надо ли это учитывать в методе, если это unchecked.*/
        //Проверка на неверный размер массива
        try {
            arraySummation(new String[3][2]);
        } catch (MyArraySizeException | MyArrayDataException exc) {
            System.out.println(exc);
        }

        //Проверка на неверное значение в массиве
        try {
            String[][] correctArrayWithIncorrectData =
                    {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "LOL", "8", "7"}, {"1", "1", "A", "1"}};
            arraySummation(correctArrayWithIncorrectData);
        } catch (MyArraySizeException | MyArrayDataException exc) {
            System.out.println(exc);
        }

        //Проверка с верными значениями
        try {
            String[][] correctArray =
                    {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "6", "8", "7"}, {"1", "1", "1", "1"}};
            System.out.println("Результат вычисления: " + arraySummation(correctArray));
        } catch (MyArrayDataException | MyArraySizeException exc) {
            System.out.println(exc);
        }


    }

    public static int arraySummation(String[][] array) throws MyArraySizeException, MyArrayDataException {
        //Проверка на размер массива, если длина не 4 - кидает исключение
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException(String.format("Размер массива - %dx%d, а должен быть 4x4", array.length, array[0].length));
        }
        //логика метода
        //тут хранится адрес текущей ячейки, чтобы можно было вывести его. Не придумал варианта лучше
        StringBuilder cellAddress = null;
        try {
            int sum = 0;
            cellAddress = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    cellAddress.setLength(0);
                    cellAddress.append(i).append("x").append(j);

                    sum += Integer.parseInt(array[i][j]);
                }
            }
            return sum;
        } catch (NumberFormatException exc) {
            throw new MyArrayDataException(String.format("В ячейке %s находятся неверные данные", cellAddress));
        }
    }
}