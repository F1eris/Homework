import com.github.javafaker.Faker;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("ru"));
        System.out.println(faker.name().firstName());
    }
}