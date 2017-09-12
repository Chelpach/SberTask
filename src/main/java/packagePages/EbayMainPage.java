package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 12.09.2017.
 */
public class EbayMainPage extends BasePage {
    @FindBy(css = "#gh-ug-flex>a")
    public WebElement signUp;

    public EbayMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
