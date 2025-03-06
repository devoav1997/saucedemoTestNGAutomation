package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver driver;

    private By cartIcon = By.xpath("//div[@id='shopping_cart_container']/a[@data-test='shopping-cart-link']");
    private By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    private By cartItems = By.xpath("//div[@class='cart_item' and @data-test='inventory-item']");
    private By removeButton = By.xpath("//button[@data-test='remove-sauce-labs-backpack']");
    private By cartItemNames = By.xpath("//div[@data-test='inventory-item-name']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> items = driver.findElements(cartItemNames);
        for (WebElement item : items) {
            if (item.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCartEmpty() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.isEmpty();
    }

    public String getCartItemCount() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void removeProduct() {
        driver.findElement(removeButton).click();
    }



}
