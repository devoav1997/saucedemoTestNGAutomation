package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By inventoryTitle = By.className("title");
    private By productName;
    private By addToCartButton;
    private By cartIcon = By.xpath("//div[@id='shopping_cart_container']");
    private By checkoutButton = By.xpath("//button[@id='checkout']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInventoryDisplayed() {
        return driver.findElement(inventoryTitle).isDisplayed();
    }

    public void selectProduct(String product){
        productName = By.xpath("//div[@data-test='inventory-item-name' and text()='" + product + "']");
        driver.findElement(productName).click();
    }

    public void addToCart(){
        addToCartButton = By.xpath("//button[text()='Add to cart']");
        driver.findElement(addToCartButton).click();
    }

    public void goToCart(){
        driver.findElement(cartIcon).click();
    }

    public void proceedToCheckout(){
        driver.findElement(checkoutButton).click();
    }


}