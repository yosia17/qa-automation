package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepCheckout {
    WebDriver driver;

    StepAddProduct stepAddProduct = new StepAddProduct();

    public StepCheckout() {
        this.driver = stepAddProduct.getDriver();
    }

    @Given("User is on Your Cart Page")
    public void userIsOnYourCartPage() {
        stepAddProduct.userIsOnTheProductPage();
        stepAddProduct.userGoToTheCart();
    }


    @When("User clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        driver.findElement(By.cssSelector("button[data-test=checkout]")).click();
    }

    @And("User fill the form with {}, {}, {}")
    public void userFillTheFormWith(String arg0, String arg1, String arg2) {
        driver.findElement(By.cssSelector("input[data-test=firstName]")).sendKeys(arg0);
        driver.findElement(By.cssSelector("input[data-test=lastName]")).sendKeys(arg1);
        driver.findElement(By.cssSelector("input[data-test=postalCode]")).sendKeys(arg2);
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        driver.findElement(By.cssSelector("input[data-test=continue]")).click();
    }

    @And("User clicks on Finish button")
    public void userClicksOnFinishButton() {
        driver.findElement(By.cssSelector("button[data-test=finish]")).click();
    }

    @Then("User should be on Checkout Complete Page")
    public void userShouldBeOnCheckoutCompletePage() {
        String checkoutCompletePageAssert = driver.findElement(By.cssSelector("span[class=title]")).getText();
        String expected = "Checkout: Complete!";

        Assert.assertEquals(expected, checkoutCompletePageAssert);

        driver.quit();
    }

    @Then("User should see {} message")
    public void userShouldSeeErrorMessage(String errorStatus) {
        String expectedErrorMessage;
        expectedErrorMessage = switch (errorStatus) {
            case "firstName" :
                yield "Error: First Name is required";
            case "lastName" :
                yield "Error: Last Name is required";
            default :
                yield "Error: Postal Code is required";
        };

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();

        Assert.assertEquals(expectedErrorMessage, errorMessage);

        driver.quit();
    }
}
