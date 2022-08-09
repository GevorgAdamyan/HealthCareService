package support;

import com.github.javafaker.Faker;

public class Utils {
    static Faker faker = new Faker();

    public static String getRandomComment() {
        return faker.lorem().paragraph();
    }
}
