package pages;

import org.openqa.selenium.By;
import seleniumFactory.TestContext;

public class HomePage {
    private TestContext context;

    private final By PRIMARY_BUTTON = By.className("btn-primary-wide");

    private final By ACCEPT_COOKIES_BUTTON = By.id("ma-cmp-accept");


    public HomePage(TestContext context) {
        this.context = context;
    }

    public HomePagePromise pressOnButton(String buttonName) {
        context.getAllElements(PRIMARY_BUTTON).stream()
                .filter(webElement -> webElement.getText().equals(buttonName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No element was found"))
                .click();
        return new HomePagePromise(context);
    }

    public HomePage acceptCookies() {
        if (context.getElement(ACCEPT_COOKIES_BUTTON).isDisplayed()) {
            context.getElement(ACCEPT_COOKIES_BUTTON).click();
        }
        return this;
    }

    public class HomePagePromise {
        private TestContext context;

        HomePagePromise (TestContext context) {
            this.context = context;
        }

        public HomePagePromise andGetHomePagePromise() {
            return new HomePagePromise(context);
        }

        public SignUpPage andGetSignUpPage() {
            return new SignUpPage(context);
        }

        public SignInPage andGetSignInPagePromise() {
            return new SignInPage(context);
        }
    }
}
