package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepLogout {
    WebDriver driver;

    StepLogin stepLogin = new StepLogin();

    public StepLogout() {
        this.driver = stepLogin.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        stepLogin.userOnLoginPage();
        stepLogin.userInputUsername();
        stepLogin.userInputPassword();
        stepLogin.userClickButtonLogin();
    }

    @When("User clicks on burger menu")
    public void userClicksOnBurgerMenu() {
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
    }

    @And("User clicks on logout button")
    public void userClicksOnLogoutButton() {
        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
    }

    @Then("User is logged out")
    public void userIsLoggedOut() {
        String loginPageAssert = driver.findElement(By.cssSelector(".login_logo")).getText();
        Assert.assertEquals("Swag Labs", loginPageAssert);

        driver.quit();
    }
}
