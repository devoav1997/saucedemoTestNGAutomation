package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class HomePage {
    private WebDriver driver;
    private By inventoryTitle = By.className("title");
    private By productName;
    private By addToCartButton;
    private By cartIcon = By.xpath("//div[@id='shopping_cart_container']");
    private By checkoutButton = By.xpath("//button[@id='checkout']");

    private By productList = By.xpath("//div[@data-test='inventory-item']");
    private By productNames = By.xpath("//div[@class='inventory_item_name']");
    private By productPrices = By.xpath("//div[@class='inventory_item_price']");
    private By filterDropdown = By.xpath("//select[@class='product_sort_container']");
    private By productDetail = By.xpath("//div[@class='inventory_details_name large_size']");

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
   
    public boolean isProductCatalogDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Menunggu hingga 10 detik
    
            // Menunggu setidaknya satu elemen inventory muncul
            WebElement inventoryList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_item' and @data-test='inventory-item']")));
            
            // Pastikan ada lebih dari satu produk di katalog
            int productCount = driver.findElements(By.xpath("//div[@class='inventory_item' and @data-test='inventory-item']")).size();
    
            if (inventoryList.isDisplayed() && productCount > 0) {
                System.out.println("Product catalog is displayed with " + productCount + " items.");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Product catalog is not displayed: " + e.getMessage());
        }
        return false;
    }
    
    
    

    public void selectFilterOption(String filterOption){
        Select filter = new Select(driver.findElement(filterDropdown));
        filter.selectByVisibleText(filterOption);
    }

    public List<String> getProductNames(){
        return driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        return driver.findElements(productPrices)
                     .stream()
                     .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                     .collect(Collectors.toList());
    }

    public void clickOnProduct(String productName){
        WebElement product = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='" + productName + "']"));
        product.click();
    }

    public boolean isProductDetailDisplayed(String productName){
        WebElement productDetails = driver.findElement(productDetail);
        return productDetails.getText().equals(productName);
    }
}