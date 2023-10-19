package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepAddProduct {
    WebDriver driver;
    StepLogout stepLogout = new StepLogout();

    public StepAddProduct() {
        this.driver = stepLogout.getDriver();
    }

    @Given("User is on the product page")
    public void userIsOnTheProductPage() {
        stepLogout.userIsLoggedIn();
    }

    @When("User add {} to cart")
    public void userAddProductToCart(String product) {
        String cssProductConvert = product.toLowerCase().replace(" ", "-");
        String cssSelectorString = "button[data-test=add-to-cart-" + cssProductConvert + "]";
        driver.findElement(By.cssSelector(cssSelectorString)).click();

        int cartCount = Integer.parseInt(driver.findElement(By.cssSelector("span[class=shopping_cart_badge]")).getText());
        Assert.assertEquals(1, cartCount);
    }

    @And("User go to the cart")
    public void userGoToTheCart() {
        driver.findElement(By.cssSelector("a[class=shopping_cart_link]")).click();
    }

    @Then("I should see the {} in the cart")
    public void iShouldSeeTheInTheCart(String arg0) {
        String cartPageAssert = driver.findElement(By.cssSelector("div[class=inventory_item_name]")).getText();
        Assert.assertEquals(arg0, cartPageAssert);
    }
}
