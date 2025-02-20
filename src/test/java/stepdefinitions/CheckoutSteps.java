package stepdefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverSetup;

public class CheckoutSteps {
    WebDriver driver = WebDriverSetup.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("the user selects a product {string}")
    public void userSelectsProduct(String product) {
        homePage.selectProduct(product);
    }

    @When("adds the product to the cart")
    public void addsProductToCart() {
        homePage.addToCart();
    }

    @When("proceeds to checkout")
    public void proceedsToCheckout() {
        homePage.goToCart();
        homePage.proceedToCheckout();
    }

    @When("fills in the checkout information with {string} {string} {string}")
    public void fillsInCheckoutInformation(String firstName, String lastName, String postalode) {
        checkoutPage.enterCheckoutInformation(firstName, lastName, postalode);
        checkoutPage.clickContinue();
    }

    @When("completes the purchase")
    public void completesPurchase() {
        checkoutPage.complatePurchase();
    }
    
    @Then("a confirmation message {string} should be displayed")
    public void confirmationMessageDisplayed(String expectedMessage) {
        String actualMessage = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Confirmation message mismatch!");
        WebDriverSetup.closeDriver();
    }
}
