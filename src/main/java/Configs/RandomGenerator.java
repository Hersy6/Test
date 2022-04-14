package Configs;

import java.util.Random;

public class RandomGenerator {

    public RandomGenerator RandomEmail( ) {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String m = "@gmail.com";

        Email = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString() + m;

        System.out.println(Email);
        return this;
    }
    public String Email = RandomEmail().Email;

}
