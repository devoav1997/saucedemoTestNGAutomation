package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// public class WebDriverSetup {
//     private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//     public static WebDriver getDriver() {
//         if (driver.get() == null) {
//             ChromeOptions options = new ChromeOptions();
//             options.addArguments("--remote-allow-origins=*");
//             options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess");
            
//             driver.set(new ChromeDriver(options));
//             driver.get().manage().window().maximize();
//         }
//         return driver.get();
//     }

//     public static void closeDriver() {
//         if (driver.get() != null) {
//             driver.get().quit();
//             driver.remove();
//         }
//     }
// }

public class WebDriverSetup {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }

    public static void closeDriver()  {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }



}