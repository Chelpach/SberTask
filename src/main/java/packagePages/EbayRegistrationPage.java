package packagePages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия":
                fillField(lastname, value);
                break;
            case  "Имя":
                fillField(firstname, value);
                break;
            case  "Телефон":
                fillField(phoneFlagComp1, value);
                break;
            case  "Адрес эл. почты":
                fillField(email, value);
                break;
            case  "Пароль":
                fillField(password, value);
                break;
            case  "Повторный ввод эл. почты":
                fillField(remail, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
}
