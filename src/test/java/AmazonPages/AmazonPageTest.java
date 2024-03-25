package AmazonPages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class AmazonPageTest {

    public static void main(String[] args) throws InterruptedException, TimeoutException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open Amazon homepage
        driver.get("https://www.amazon.in/");

        // Implicit wait for 30 seconds (optional)
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Explicit wait to avoid race conditions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
        // Clear and search for "Apple iPhone 13 (128GB) - Blue"
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        searchBox.clear();
        searchBox.sendKeys("Apple iPhone 13 (128GB) - Blue");
        driver.findElement(By.id("nav-search-submit-button")).click();
        try {
        WebElement iPhoneProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Apple iPhone 13 (128GB) - Blue']")));
        iPhoneProduct.click();
        }catch(TimeoutException e) {
        	System.out.println("Timeout Exception");
        }
        String iPhoneWindowTitle = "Amazon.in : Apple iPhone 13 (128GB) - Blue, (1) SIM (GSM/CDMA) + 0 Offers";
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(iPhoneWindowTitle)) {
                break;
            }
        }

        // Find and click "Add to Cart" button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='add-to-cart-button'])[2]"))).click();


        // Go to shopping cart
//        driver.findElement(By.cssSelector("span.nav-cart-count")).click();
        driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();
        // Verify shopping cart title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.in Shopping Cart";

        if (actualTitle.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title didn't match");
        }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
        driver.quit();
        }
    }
}
