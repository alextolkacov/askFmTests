package pages;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import seleniumFactory.TestContext;

import static org.junit.jupiter.api.Assertions.*;

public class SignUpPage {
    private TestContext context;

    private final By EMAIL_FIELD = By.id("user_email");

    private final By DATE_DAY = By.id("date_day");

    private final By DAY_OPTION = By.xpath(".//select[@id='date_day']/option");

    private final By DATE_MONTH = By.id("date_month");

    private final By MONTH_OPTION = By.xpath(".//select[@id='date_month']/option");

    private final By DATE_YEAR = By.id("date_year");

    private final By YEAR_OPTION = By.xpath(".//select[@id='date_year']/option");

    private final By REGISTRATION_BUTTON = By.xpath(".//input[@type = 'submit']");

    private final By AGREE_TO_ALL_CONDITIONS_CBX = By.xpath(".//label[@for = 'agree_to_all']");

    private final By ERROR_MESSAGE = By.className("flash-message alert");

    public SignUpPage(TestContext context) {
        this.context = context;
    }

    public SignUpPage fillEmailField(String email) {
        context.getElement(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    public SignUpPage setDate(String day, String month, String year) {
        setDay(day)
                .setMonth(month)
                .setYear(year);
        return this;
    }

    public SignUpPage setDay(String day) {
        context.getElement(DATE_DAY).click();
        context.getAllElements(DAY_OPTION).stream()
                .filter(webElement -> webElement.getText().equals(day))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No day is available for selection"))
                .click();
        return this;
    }

    public SignUpPage setMonth(String month) {
        context.getElement(DATE_MONTH).click();
        context.getAllElements(MONTH_OPTION).stream()
                .filter(webElement -> webElement.getText().equals(month))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No month is available for selection"))
                .click();
        return this;
    }

    public SignUpPage setYear(String year) {
        context.getElement(DATE_YEAR).click();
        context.getAllElements(YEAR_OPTION).stream()
                .filter(webElement -> webElement.getText().equals(year))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No year is available for selection"))
                .click();
        return this;
    }

    public SignUpPage agreeToAllConditions() {
        context.getElement(AGREE_TO_ALL_CONDITIONS_CBX).click();
        return this;
    }

    public SignUpPage pushRegistrationButton() {
        context.getElement(REGISTRATION_BUTTON).click();
        return this;
    }

    public String fillEmailFieldWithRandomEmail() {
        RandomString randomString = new RandomString(8);
        return randomString.nextString() + "@" + randomString.nextString() + ".com";
    }

    public SignUpPage verifyExistingAccountMessage() {
        assertFalse(context.isElementPresent(ERROR_MESSAGE), "No error message is visible");
        return this;
    }

    public SignUpPage verifyErrorMessageText(String errorMessage) {
        assertEquals(context.getElement(ERROR_MESSAGE).getText(), errorMessage);
        return this;
    }
}
