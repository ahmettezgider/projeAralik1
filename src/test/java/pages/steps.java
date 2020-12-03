package pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Condition;

import static utilities.ElementClass.$;
import static utilities.ElementClass.open;


public class steps implements Locators {

    @Given("^user on \"([^\"]*)\"$")
    public void userOn(String url)  {
       open(url);
    }

    @When("^user log in with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userLogInWithUsernameAsAndPasswordAs(String email, String pass)  {

        $(loginLink)
                .shouldBe(Condition.visible)
                .click();
        $(username)
                .waitUntil(Condition.visible, 30)
                .scrollIntoView()
                .shouldBe(Condition.enable)
                .setValue(email);
        $(password)
                .setValue(pass);
        $(loginSubmitButton)
                .click();
    }


    @Then("^login should be successfull$")
    public void loginShouldBeSuccessfull() {
        $(logoutLink).shouldBe(Condition.visible);
    }

    @When("^user search \"([^\"]*)\"$")
    public void userSearch(String text)  {
        $(searchInput).setValue(text).pressEnter();
    }

    @Then("^the products should be listed$")
    public void theProductsShouldBeListed() {

    }
}
