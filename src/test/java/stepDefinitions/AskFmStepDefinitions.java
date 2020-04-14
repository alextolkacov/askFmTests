package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import pages.HomePage.HomePagePromise;
import seleniumFactory.TestContext;

public class AskFmStepDefinitions {
    private final TestContext context = new TestContext();
    private final Helpers helpers = new Helpers(context);
    private HomePage homePage;
    private SignUpPage signUpPage;
    private FeedPage feedPage;
    private SignInPage signInPage;

    @Given("Open {string} URL")
    public HomePage open_page(String url) {
        context.openPage(url);
        return homePage = new HomePage(context);
    }

    @When("Accept cookies on popup")
    public void accept_cookies_on_popup() {
        homePage.acceptCookies();
    }

    @When("Press primary button {string}")
    public HomePagePromise press_primary_button(String buttonName) {
        return homePage.pressOnButton("Sign up");
    }

    @When("Accept cookies on tab")
    public void accept_cookies_on_tab() {
        helpers.acceptCookiesOnTab();
    }

    @Then("Fill email field with random email")
    public void fill_email_field_vith_random_email() {
        signUpPage.fillEmailFieldWithRandomEmail();
    }

    @Then("Fill email field: {string}")
    public void fill_email_field(String email) {
        signUpPage.fillEmailField(email);
    }

    @Then("Set date: Day {string}, Month {string}, Year {string}")
    public void fill_date(String day, String month, String year) {
        signUpPage.setDate(day, month, year);
    }

    @When("Get Sign Up Page")
    public void and_get_sign_up_page() {
        signUpPage = new SignUpPage(context);
    }

    @When("Push 'Registration button'")
    public void push_registration_button() {
        signUpPage.pushRegistrationButton();
    }

    @When("Agree to all conditions")
    public void agree_to_all_conditions() {
        signUpPage.agreeToAllConditions();
    }

    @Then("Get Feed Page")
    public void and_get_feed_page() {
        feedPage = new FeedPage(context);
    }

    @Then("Verify Feed Page appeared")
    public void verify_feed_page_appeared() {
        feedPage.verifyPage();
    }

    @Then("Close browser")
    public void close_browser() {
        context.quit();
    }

    @Then("Verify that existing account notification appeared")
    public void verify_existing_account_message() {
        signUpPage.verifyExistingAccountMessage();
    }

    @Then("Error message text is: {string}")
    public void verify_error_message_text(String errorMessage) {
        signUpPage.verifyErrorMessageText(errorMessage);
    }

    @When("Get Sign In Page")
    public void and_get_sign_in_page() {
        signInPage = new SignInPage(context);
    }

    @When("Fill Log In fields. User: {string}, Password: {string}")
    public void fill_log_in_fields(String email, String password) {
        signInPage.fillUserFields(email, password);
    }

    @When("Push Log In button")
    public void push_log_in_button() {
        signInPage.pushLogInButton();
    }

    @When("Will Log In email field with random email and password")
    public void fill_log_in_email_field_with_random_data() {
        signInPage.fillEmailFieldWithRandomEmail()
                .fillEmailFieldWithRandomPassword();
    }

    @Then("Verify that Flash error message appeared with text: {string}")
    public void verify_flash_message_appeared(String errorMessage) {
        signInPage.verifyFlashErrorMessageAppeared()
                .verifyFlashErrorMessageText(errorMessage);
    }
}
