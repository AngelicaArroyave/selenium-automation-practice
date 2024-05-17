package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    private double totalExpected;
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void closeBrowser() {
        if(driver != null) driver.quit();
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void scrollIntoView(String locator) {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        new Actions(driver).scrollToElement(find(locator)).perform();
    }

    public void validateEquals(String locator, String expected) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        String nameBook = driver.findElement(By.xpath(locator)).getText();
        Assert.assertEquals(nameBook, expected);
    }

    public void writeElement(String locator, String keyToSend) {
        find(locator).clear();
        find(locator).sendKeys(keyToSend);
    }

    public void validateDisplayed(String locator) {
        find(locator).isDisplayed();
    }

    public double deleteSymbolPrice(String locator) {
        String price = find(locator).getText();

        return Double.parseDouble(price.substring(1).replaceAll(",", ""));
    }

    public void validatePrice(String numberProduct, String priceProduct, String totalPrice) {
        int number = Integer.parseInt(numberProduct);
        double priceComplete = deleteSymbolPrice(priceProduct);
        double calculatedPrice = number * priceComplete;
        totalExpected = deleteSymbolPrice(totalPrice);
        System.out.println(totalExpected);
        Assert.assertEquals(calculatedPrice, totalExpected);
    }

    public void validateTotalPrice(String locator) {
        double totalPrice = deleteSymbolPrice(locator);
        Assert.assertEquals(totalPrice, totalExpected);
    }
}
