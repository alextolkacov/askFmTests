package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Helpers;
import pages.HomePage;
import pages.HomePage.HomePagePromise;
import pages.SignUpPage;
import seleniumFactory.TestContext;

public class AskFmStepDefinitions {
    private TestContext context = new TestContext();
    private Helpers helpers = new Helpers(context);
    private HomePage homePage;
    private SignUpPage signUpPage;

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

    @Then("Fill email field: {string}")
    public void fill_email_field(String email) {
        signUpPage.fillEmailField(email);
    }

    @Then("Set date: Day {string}, Month {string}, Year {string}")
    public void fill_date(String day, String month, String year) {
        signUpPage.setDate(day,month, year);
    }

    @When("Get Sign Up Page")
    public void and_get_sign_up_page() {
        signUpPage = new SignUpPage(context);
    }
}
