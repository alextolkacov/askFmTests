package pages;

import org.openqa.selenium.By;
import seleniumFactory.TestContext;

import static org.junit.jupiter.api.Assertions.*;

public class FeedPage {
    private TestContext context;

    private final By ASK_BOX_SECTION = By.xpath(".//section[@class = 'askBox section rsp-gte-tablet']");

    private final By DISCOVERY_WELCOME_SECTION = By.className("discoveryWelcome");

    private final By NAVIGATION_TABS = By.className("rsp-eql-desktop");

    public FeedPage(TestContext context) {
        this.context = context;
    }

    public FeedPage verifyPage() {
        assertAll("This is not a correctPage",
                () -> assertFalse(context.isElementPresent(ASK_BOX_SECTION),
                        "Ask box section is not present"),
                () -> assertFalse(context.isElementPresent(DISCOVERY_WELCOME_SECTION),
                        "Discovery welcome section is not present"),
                () -> assertFalse(context.isElementPresent(NAVIGATION_TABS),
                        "Navigation tabs are not present"));
        return this;
    }
}
