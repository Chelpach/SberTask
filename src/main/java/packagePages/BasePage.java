package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 12.09.2017.
 */
public class BasePage {

    WebDriver driver;

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}
