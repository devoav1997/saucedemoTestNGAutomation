package stepdefinitions;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverSetup;

public class ProductCatalogSteps {
    WebDriver driver = WebDriverSetup.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Then("the user should see the product catalog")
    public void productCatalogShouldBeDisplayed() {
        Assert.assertTrue(homePage.isProductCatalogDisplayed(), "Product catalog is not displayed");
        WebDriverSetup.closeDriver();
    }

    @When("the user selects filter option {string}")
    public void userSelectsFilterOption(String filterOption) {
        homePage.selectFilterOption(filterOption);
    }

    @Then("the products should be sorted by {string}")
    public void productsShouldBeSorted(String sortOption) {
        if (sortOption.equals("Name (A to Z)")) {
            List<String> productNames = homePage.getProductNames();
            List<String> sortedNames = productNames.stream().sorted().collect(Collectors.toList());
            Assert.assertEquals(productNames, sortedNames, "Products are not sorted by Name (A to Z)");
        } else if (sortOption.equals("Price (low to high)")) {
            List<Double> productPrices = homePage.getProductPrices();
            List<Double> sortedPrices = productPrices.stream().sorted().collect(Collectors.toList());
            Assert.assertEquals(productPrices, sortedPrices, "Products are not sorted by Price (low to high)");
        }
        WebDriverSetup.closeDriver();
    }

    @When("the user clicks on product {string}")
    public void userClicksOnProduct(String productName) {
        homePage.clickOnProduct(productName);
    }

    @Then("the product detail page should be displayed with product name {string}")
    public void productDetailPageShouldBeDisplayed(String productName) {
        Assert.assertTrue(homePage.isProductDetailDisplayed(productName), "Product detail page is not displayed!");
        WebDriverSetup.closeDriver();
    }



}
