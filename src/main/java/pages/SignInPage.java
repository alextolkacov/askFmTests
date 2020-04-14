package pages;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import seleniumFactory.TestContext;

import static org.junit.jupiter.api.Assertions.*;

public class SignInPage {
    private TestContext context;

    private final By EMAIL_FIELD = By.xpath(".//input[@name = 'login']");
    private final By PASSWORD_FIELD = By.xpath(".//input[@name = 'password']");
    private final By SUBMIT_BUTTON = By.className(".//input[@type = 'submit']");
    private final By FLASH_MESSAGE_ALERT = By.className("flash-message alert");

    public SignInPage(TestContext context) {
        this.context = context;
    }

    public SignInPage fillEmailField(String email) {
        context.getElement(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    public SignInPage fillPasswordField(String password) {
        context.getElement(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    public SignInPage pushLogInButton() {
        context.getElement(SUBMIT_BUTTON).click();
        return this;
    }

    public SignInPage fillUserFields(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
        return this;
    }

    public SignInPage fillEmailFieldWithRandomEmail() {
        fillEmailField("testUser@" + new RandomString(8).nextString() + ".com");
        return this;
    }

    public SignInPage fillEmailFieldWithRandomPassword() {
        fillPasswordField(new RandomString(8).nextString());
        return this;
    }

    public SignInPage verifyFlashErrorMessageAppeared() {
        assertFalse(context.isElementPresent(FLASH_MESSAGE_ALERT), "Flash message alert is not visible");
        return this;
    }

    public SignInPage verifyFlashErrorMessageText(String errorMessage) {
        assertEquals(context.getElement(FLASH_MESSAGE_ALERT).getText(), errorMessage);
        return this;
    }
}
