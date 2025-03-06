package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSetup {
    private static WebDriver driver;

    // public static WebDriver getDriver() {
    //     if (driver == null) {
    //         WebDriverManager.chromedriver().setup();

    //         ChromeOptions options = new ChromeOptions();
    //         options.addArguments("--remote-allow-origins=*");
    //         options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess");
            
    //         driver = new ChromeDriver(options);
    //         driver.manage().window().maximize();
    //     }
    //     return driver;
    // }

    public static WebDriver getDriver() {
    if (driver == null) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    return driver;
}


    public static void closeDriver() {
        if (driver != null) {
            try {
                Thread.sleep(5000); // Delay sebelum menutup browser
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
            driver = null;
        }
    }
}
