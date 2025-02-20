package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Locator untuk Checkout
    private By firstNameField = By.xpath("//input[@id='first-name']");
    private By lastNameField = By.xpath("//input[@id='last-name']");
    private By postalCodeField = By.xpath("//input[@id='postal-code']");
    private By continueButton = By.xpath("//input[@id='continue']");
    private By finishButton = By.xpath("//button[text()='Finish']");
    private By confirmationMessage = By.xpath("//h2[@class='complete-header']");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public void complatePurchase(){
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage(){
        return driver.findElement(confirmationMessage).getText();
    }


}
