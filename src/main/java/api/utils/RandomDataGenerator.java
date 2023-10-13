package api.utils;

import com.github.javafaker.Faker;

public class RandomDataGenerator {
    private final Faker faker;
    public RandomDataGenerator() {
        faker = new Faker();
    }

    public String generateRandomUsername() {
        return faker.name().username();
    }
    public String generateRandomPassword() {
        String uppercaseChars = faker.lorem().characters(3, true, false);
        String lowercaseChars = uppercaseChars.toLowerCase();
        String numericChars = faker.number().digits(2);

        return uppercaseChars + lowercaseChars + "@" + numericChars;
    }
}



