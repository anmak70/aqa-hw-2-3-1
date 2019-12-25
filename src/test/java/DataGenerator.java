
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    private DataGenerator() {}

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

    static String getDate(int daysPlus) {
        LocalDate date = LocalDate.now().plusDays(daysPlus);
        String dateMeeting = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return dateMeeting;
    }
}