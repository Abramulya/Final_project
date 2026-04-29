package utils;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataGenerator {
    private static final Faker faker = new Faker(new Locale("ru"));

    public static String generateUniqueEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        return faker.internet().password(8, 20, true, true, true);
    }

    public static String generateUsername() {
        return faker.name().username();
    }

    public static String generateAdTitle() {
        return faker.commerce().productName();
    }

    public static String generateAdDescription() {
        return faker.lorem().paragraph(2);
    }

    public static int generatePrice() {
        return ThreadLocalRandom.current().nextInt(100, 100000);
    }

    public static String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String getRandomCategory() {
        String[] categories = {"Электроника", "Одежда", "Недвижимость", "Услуги", "Авто"};
        return categories[ThreadLocalRandom.current().nextInt(categories.length)];
    }
}