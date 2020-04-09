package pages;

import org.openqa.selenium.By;
import seleniumFactory.TestContext;

public class Helpers {
    private TestContext context;

    private final By ACCEPT_COOKIES_TAB = By.xpath(".//a[@data-action='PolicyAccept']");

    public Helpers(TestContext context) {
        this.context = context;
    }

    public void acceptCookiesOnTab() {
        context.waitForElement(ACCEPT_COOKIES_TAB);
        if (context.getElement(ACCEPT_COOKIES_TAB).isDisplayed()) {
            context.getElement(ACCEPT_COOKIES_TAB).click();
        }
    }
}
