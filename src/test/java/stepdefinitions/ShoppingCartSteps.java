package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverSetup;

public class ShoppingCartSteps {
    WebDriver driver = WebDriverSetup.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);


    @Then("the cart icon should show {string}")
    public void cartIconShouldShow(String expectedCount) {
        Assert.assertEquals(cartPage.getCartItemCount(), expectedCount, "Cart item count mismatch!");
        WebDriverSetup.closeDriver();
    }

    @When("the user opens the cart")
    public void userOpensCart() {
        cartPage.openCart();
    }

    @Then("the cart should contain {string}")
    public void cartShouldContain(String productName) {
        Assert.assertTrue(cartPage.isProductInCart(productName), "Product is not in the cart!");
        WebDriverSetup.closeDriver();
    }

    @When("the user removes the product {string}")
    public void userRemovesProduct(String productName) {
        cartPage.removeProduct();
    }

    @Then("the cart should be empty")
    public void cartShouldBeEmpty() {
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty!");
        WebDriverSetup.closeDriver();
    }
}
