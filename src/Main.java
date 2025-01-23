import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        /*Если передать массив [0][1] например, то будет ArrayIndexOutOfBoundsException
        Не знаю надо ли это учитывать в методе, если это unchecked.*/
        //Проверка на неверный размер внешнего массива
        try {
            arraySummation(new String[3][2]);
        } catch (MyArraySizeException | MyArrayDataException exc) {
            System.out.println(exc);
        }

        //Проверка на неверный размер внутреннего массива
        try {
            String[][] incorrectInnerArray =
                    {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "6", "8", "7", "15", "16"}, {"1", "1", "1", "1"}};
            arraySummation(incorrectInnerArray);
        } catch (MyArrayDataException | MyArraySizeException exc) {
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
        if (array.length != 4) {
            throw new MyArraySizeException(String.format("Длина внешнего массива = %d, а должна быть 4", array.length));
        }
        for (String[] innerArray : array) {
            if (innerArray.length != 4) {
                throw new MyArraySizeException(String.format("Длина внутреннего массива = %d, а должна быть 4", innerArray.length));
            }
        }

        //логика метода
        //тут хранится адрес текущей ячейки, чтобы можно было вывести его. Не придумал варианта лучше

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException exc) {
                    throw new MyArrayDataException(String.format("В ячейке %dx%d находятся неверные данные", i, j));
                }

            }
        }
        return sum;


    }
}