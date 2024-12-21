package Utils;

import com.github.javafaker.Faker;


public class DataFaker {

    static Faker faker = new Faker();
    static String firstName = faker.name().firstName();
    static String lastName =faker.name().lastName();
    static String zipCode =faker.address().zipCode();

    public static Faker getFaker() {
        return faker;
    }
    public static String getFirstName() {
        return firstName;
    }
    public static String getLastName() {
        return lastName;
    }
    public static String getZipCode() {
        return zipCode;
    }

}
