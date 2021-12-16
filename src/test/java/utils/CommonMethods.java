package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void openBrowser() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                if (ConfigReader.getPropertyValue("headless").equals("true")) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                } else {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click;", element);
    }

    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;

        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " + getTimeStamp("yyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public void tearDown() {
        driver.quit();
    }

    public static void setUpChrome(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    public static void setUpFirefox(String url) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(url);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void navigateToURL(String url) {
        driver.navigate().to(url);
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void navigateForward() {
        driver.navigate().forward();
    }

    public static void navigateRefresh() {
        driver.navigate().refresh();
    }

    public static void getUrl(String url) {
        driver.get(url);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static void switchToWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public static void implicitlyWait10sec() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void explicitWait10secXpath(String xpath) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void closeTab() {
        driver.close();
    }

    public static void quitBrowser() {
        driver.quit();
    }
}
