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


public class StepLogin {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";


    @Given("User on Login Page")
    public void userOnLoginPage() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        driver.get(baseUrl);



        String loginPageAssert = driver.findElement(By.cssSelector(".login_logo")).getText();
        Assert.assertEquals("Swag Labs", loginPageAssert);

    }

    @When("User input wrong username")
    public void userInputWrongUsername() {
        driver.findElement(By.cssSelector("input[data-test=username]")).sendKeys("lalala@gmail.com");
    }

    @And("User input wrong password")
    public void userInputWrongPassword() {
        driver.findElement(By.cssSelector("input[data-test=password]")).sendKeys("lalala");
    }

    @And("User click button Login")
    public void userClickButtonLogin() {
        driver.findElement(By.cssSelector("input[data-test=login-button]")).click();
    }

    @When("User input empty username")
    public void userInputEmptyUsername() {
        driver.findElement(By.cssSelector("input[data-test=username]")).sendKeys("");
    }

    @And("User input password")
    public void userInputPassword() {
        driver.findElement(By.cssSelector("input[data-test=password]")).sendKeys("secret_sauce");
    }

    @Then("User get error invalid username or password")
    public void userGetErrorMessage() {
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);

        driver.quit();
    }

    @Then("User get error username is required")
    public void userGetErrorUsernameIsRequired() {
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
        Assert.assertEquals("Epic sadface: Username is required", errorMessage);

        driver.quit();
    }

    @When("User input username")
    public void userInputUsername() {
        driver.findElement(By.cssSelector("input[data-test=username]")).sendKeys("standard_user");
    }

    @And("User input empty password")
    public void userInputEmptyPassword() {
        driver.findElement(By.cssSelector("input[data-test=password]")).sendKeys("");
    }

    @Then("User get error password is required")
    public void userGetErrorPasswordIsRequired() {
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
        Assert.assertEquals("Epic sadface: Password is required", errorMessage);

        driver.quit();
    }

    @Then("User get success login")
    public void userGetSuccessLogin() {
        String titleHomePage = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Products", titleHomePage);

        driver.quit();
    }
}