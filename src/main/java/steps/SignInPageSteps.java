package steps;

import org.openqa.selenium.WebElement;
import packagePages.MailPage;
import packagePages.SignInPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.getDriver;

/**
 * Created by user on 13.09.2017.
 */
public class SignInPageSteps{

    @Step("Поле {0} заполняется значением {2}")
    protected void fillField(WebElement element, String value) {
        new MailPage(getDriver()).fillField(element, value);
    }

    @Step("Ввод логина")
    public void ebayLogin() {
        new SignInPage(getDriver()).login.clear();
        new SignInPage(getDriver()).login.sendKeys(BaseSteps.login);
    }

    @Step("Ввод пароля")
    public void ebayPassword() {
        new SignInPage(getDriver()).password.sendKeys(BaseSteps.passwordApp);
    }

    @Step("Нажатие кнопки далее")
    public void confirmPassowrd() {
        new SignInPage(getDriver()).enterButton.click();
    }

}
