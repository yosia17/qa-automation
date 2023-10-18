package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepLogout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User is logged in")
    public void userIsLoggedIn() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("input[data-test=username]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[data-test=password]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[data-test=login-button]")).click();
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
    }
}
