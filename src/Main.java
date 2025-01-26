import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        //ЗАДАНИЕ 1
        String[] array = {"Один", "Два", "Три", "Четыре", "Пять",
                "Шесть", "Семь", "Один", "Два", "Четыре",
                "Восемь", "Девять", "Девять", "Один", "Пять",
                "Пять", "Пять", "Девять", "Девять", "Девять",};

        //linked чтобы красиво по-порядку было
        LinkedHashMap<String, Integer> wordsHashMap = new LinkedHashMap<>();
        for (String string : array) {
            wordsHashMap.put(string, wordsHashMap.getOrDefault(string, 0) + 1);
        }

        //Вывод уникальных слов
        System.out.println("Уникальные слова в массиве:");
        System.out.println(wordsHashMap.keySet());
        System.out.println();

        //Вывод количества повторений
        System.out.println("Количество повторений каждого слова:");
        System.out.println(wordsHashMap.entrySet());
        System.out.println();

        //проверка задания 2
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Пупкин", "88888888888");
        telephoneDirectory.add("Иванов", "12345678910");
        telephoneDirectory.add("Петров", "98765432109");
        telephoneDirectory.add("Пупкин", "00000000000");
        telephoneDirectory.add("Пупкин", "88888888888");

        System.out.println();

        //Поиск телефонов по фамилии пупкин
        System.out.println("Номера телефонов по фамилии пупкин:");
        System.out.println(telephoneDirectory.get("пупкин"));

    }
}