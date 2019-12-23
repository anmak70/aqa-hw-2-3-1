import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestCardDeliveryReschedule {

    @Test
    void shouldScheduledMeeting() {
        open("http://localhost:9999");
        $("[data-test-id = city] input").setValue(DataGenerator.getCity());
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=date] input").setValue(DataGenerator.getDateFirst());
        $("[data-test-id = name] input").setValue(DataGenerator.getName());
        $("[data-test-id = phone] input").setValue(DataGenerator.getPhone());
        $("[data-test-id = agreement]").click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $("[data-test-id = success-notification]").waitUntil(Condition.visible, 5000);
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=date] input").setValue(DataGenerator.getDateSecond());
        $(".button__text").click();
        $("[data-test-id='replan-notification']").waitUntil(Condition.visible,
                5000);
        $(".button__text").click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }
}
