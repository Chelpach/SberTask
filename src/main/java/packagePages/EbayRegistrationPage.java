package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 12.09.2017.
 */
public class EbayRegistrationPage extends BasePage {

    @FindBy(css = "#email")
    public WebElement email;

    @FindBy(css = "#remail")
    public WebElement remail;

    @FindBy(css = "#PASSWORD")
    public WebElement password;

    @FindBy(css = "#firstname")
    public WebElement firstname;

    @FindBy(css = "#lastname")
    public WebElement lastname;

    @FindBy(css = "#phoneFlagComp1")
    public WebElement phoneFlagComp1;

    @FindBy(css = "#sbtBtn")
    public WebElement signUpButton;

    @FindBy(css = "#reginter")
    public WebElement reginter;


    public EbayRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
