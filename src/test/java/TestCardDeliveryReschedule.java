import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;

public class TestCardDeliveryReschedule {
    private By dateMeeting = cssSelector("[data-test-id=date] input");

    @Test
    void shouldScheduledMeeting() {
        open("http://localhost:9999");

        $("[data-test-id = city] input").setValue(DataGenerator.getCity());
        $(dateMeeting).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(dateMeeting).setValue(DataGenerator.getDate(4));
        $("[data-test-id = name] input").setValue(DataGenerator.getName());
        $("[data-test-id = phone] input").setValue(DataGenerator.getPhone());
        $("[data-test-id = agreement]").click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $("[data-test-id = success-notification]").waitUntil(Condition.visible, 5000);
        $(dateMeeting).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(dateMeeting).setValue(DataGenerator.getDate(6));
        $(".button__text").click();
        $("[data-test-id='replan-notification']").waitUntil(Condition.visible,
                5000);
        $(".button__text").click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldWarningNotValidPhoneInput() throws InterruptedException {
        open("http://localhost:9999");
        $("[data-test-id = city] input").setValue(DataGenerator.getCity());
        $(dateMeeting).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(dateMeeting).setValue(DataGenerator.getDate(4));
        $("[data-test-id = name] input").setValue(DataGenerator.getName());
        $("[data-test-id = phone] input").setValue("795");
        $("[data-test-id = agreement]").click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $("[data-test-id = success-notification]").shouldNot(Condition.visible).wait(15000);
    }
}
