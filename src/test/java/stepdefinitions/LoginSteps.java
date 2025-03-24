package stepdefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qase.api.annotation.QaseId;

public class LoginSteps {

    WebDriver driver = WebDriverSetup.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test // Anotasi TestNG
    @QaseId(1) // QaseId hanya pada level test utama
    public void loginTest() throws InterruptedException {
        userIsOnLoginPage();
        userEntersCredentials("standard_user", "secret_sauce");
        userClicksLoginButton();
        inventoryPageDisplayed();
    }


    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters {string} and {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        
    }

    @When("clicks the login button")
    public void userClicksLoginButton() {
        loginPage.clickLogin();
    }

    @Then("the inventory page should be displayed")
    public void inventoryPageDisplayed() throws InterruptedException {
        Assert.assertTrue(homePage.isInventoryDisplayed());

        // Delay sebelum browser tertutup
        System.out.println("Menunggu sebelum menutup browser...");
        Thread.sleep(5000); // 5 detik delay
        System.out.println("Menutup browser!");
      
    }

    @Then("an error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) throws InterruptedException{
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
        Thread.sleep(3000); // 5 detik delay
        WebDriverSetup.closeDriver();
    }


}