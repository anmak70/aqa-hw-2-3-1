import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class CssLocators {
    static By dateMeeting = cssSelector("[data-test-id=date] input");
    static By city = cssSelector("[data-test-id = city] input");
    static By name = cssSelector("[data-test-id = name] input");
    static By phone = cssSelector("[data-test-id = phone] input");
    static By agreement = cssSelector("[data-test-id = agreement]");
    static By successNotification = cssSelector("[data-test-id = success-notification]");
    static By replanNotification = cssSelector("[data-test-id='replan-notification']");

}
