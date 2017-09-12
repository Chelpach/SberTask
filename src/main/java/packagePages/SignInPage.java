package packagePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chelp on 12.09.2017.
 */
public class SignInPage extends BasePage {

    @FindBy (xpath = "//span/input[@placeholder='Адрес эл. почты или логин']")
    public WebElement login;

    @FindBy(css= "#sgnBt")
    public WebElement enterButton;

    @FindBy (xpath = ".//span/input[@placeholder='Пароль']")
    public WebElement password;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
