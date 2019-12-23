
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    DataGenerator() {}

    private static Faker faker = new Faker(new Locale("ru"));
    private static String name = faker.name().firstName();
    private static String surname = faker.name().lastName();
    private static String city = faker.address().cityName();
    private static String phone = faker.phoneNumber().phoneNumber();

    static String getCity () {
        return city;
    }

    static String getName() {
        return surname + " " + name;
    }

    static String getPhone () {
        return phone;
    }

    static String getDateFirst() {
        LocalDate date = LocalDate.now().plusDays(4);
        String dateFirst = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return dateFirst;
    }

    static String getDateSecond() {
        LocalDate date = LocalDate.now().plusDays(6);
        String dateSecond = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return dateSecond;
    }
}