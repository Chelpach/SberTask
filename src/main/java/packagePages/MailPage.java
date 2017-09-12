package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 12.09.2017.
 */
public class MailPage extends BasePage{

    @FindBy(css = "#identifierId")
    public WebElement login;

    @FindBy(css = "#identifierNext")
    public WebElement identifierNext;

    @FindBy(css = ".whsOnd.zHQkBf")
    public WebElement password;

    @FindBy(css = "#passwordNext")
    public WebElement passwordNext;


    @FindBy(xpath = "//*[@class='zA zE']")
    public WebElement notOpenedMail;

    @FindBy(xpath = "//*[contains(text(), 'Подтвердить')]")
    public WebElement accertButton;


    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
