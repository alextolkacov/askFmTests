package pages;

import org.openqa.selenium.By;
import seleniumFactory.TestContext;

public class SignUpPage {
    private TestContext context;

    private final By EMAIL_FIELD = By.id("user_email");

    private final By DATE_DAY = By.id("date_day");

    private final By DAY_OPTION = By.xpath(".//select[@id='date_day']/option");

    private final By DATE_MONTH = By.id("date_month");

    private final By MONTH_OPTION = By.xpath(".//select[@id='date_month']/option");

    private final By DATE_YEAR = By.id("date_year");

    private final By YEAR_OPTION = By.xpath(".//select[@id='date_year']/option");

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

    private SignUpPage setYear(String year) {
        context.getElement(DATE_YEAR).click();
        context.getAllElements(YEAR_OPTION).stream()
                .filter(webElement -> webElement.getText().equals(year))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No year is available for selection"))
                .click();
        return this;
    }
}
