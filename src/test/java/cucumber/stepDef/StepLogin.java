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

    public StepLogin() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Given("User on Login Page")
    public void userOnLoginPage() {
        String loginPageAssert = driver.findElement(By.cssSelector(".login_logo")).getText();
        Assert.assertEquals("Swag Labs", loginPageAssert);
    }

    @When("User input username")
    public void userInputUsername() {
        driver.findElement(By.cssSelector("input[data-test=username]")).sendKeys("standard_user");
    }

    @And("User input password")
    public void userInputPassword() {
        driver.findElement(By.cssSelector("input[data-test=password]")).sendKeys("secret_sauce");
    }

    @And("User click button Login")
    public void userClickButtonLogin() {
        driver.findElement(By.cssSelector("input[data-test=login-button]")).click();
    }

    @Then("User get success login")
    public void userGetSuccessLogin() {
        String titleHomePage = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Products", titleHomePage);

        driver.quit();
    }

//    ======= DDT =======
    @When("User input wrong username {}")
    public void userInputWrongUsername(String arg0) {
        driver.findElement(By.cssSelector("input[data-test=username]")).sendKeys(arg0);
    }

    @And("User input wrong password {}")
    public void userInputWrongPassword(String arg0) {
        driver.findElement(By.cssSelector("input[data-test=password]")).sendKeys(arg0);
    }

    @Then("User get error {} message")
    public void userGetErrorMessage(String arg0) {
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
        String expectedErrorMessage = "Epic sadface: " + arg0;
        Assert.assertEquals(expectedErrorMessage, errorMessage);

        driver.quit();
    }
}