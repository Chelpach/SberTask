package steps;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.TestProperties;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 13.09.2017.
 */
public class BaseSteps {
    protected static WebDriver driver;
    public static String baseUrl,login,passwordApp,mailUrl,passwordMail;
    private static Properties properties = TestProperties.getInstance().getProperties();
    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }
        baseUrl = properties.getProperty("app.url");
        mailUrl=properties.getProperty("mail.url");
        login= properties.getProperty("login");
        passwordApp=properties.getProperty("password.app");
        passwordMail=properties.getProperty("password.mail");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void switchWindow(){
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
