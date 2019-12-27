import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestCardDeliveryReschedule {

    @Test
    void shouldScheduledMeeting() {
        open("http://localhost:9999");
        $(CssLocators.city).setValue("Бе");
        $$(".menu-item__control").find(Condition.text("Белгород")).click();
        $(CssLocators.dateMeeting).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(CssLocators.dateMeeting).setValue(DataGenerator.getDate(4));
        $(CssLocators.name).setValue(DataGenerator.getName());
        $(CssLocators.phone).setValue(DataGenerator.getPhone());
        $(CssLocators.agreement).click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $(CssLocators.successNotification).waitUntil(Condition.visible, 5000);
        $(CssLocators.dateMeeting).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(CssLocators.dateMeeting).setValue(DataGenerator.getDate(6));
        $(".button__text").click();
        $(CssLocators.replanNotification).waitUntil(Condition.visible,
                5000);
        $(".button__text").click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldWarningNotValidPhoneInput() throws InterruptedException {
        open("http://localhost:9999");
        $(CssLocators.city).setValue("Бе");
        $$(".menu-item__control").find(Condition.text("Белгород")).click();
        $(CssLocators.dateMeeting).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(CssLocators.dateMeeting).setValue(DataGenerator.getDate(4));
        $(CssLocators.name).setValue(DataGenerator.getName());
        $(CssLocators.phone).setValue("795");
        $(CssLocators.agreement).click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $(CssLocators.successNotification).shouldNot(Condition.visible).wait(15000);
    }
}
