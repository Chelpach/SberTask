package steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import packagePages.EbayRegistrationPage;
import packagePages.MailPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.*;

/**
 * Created by user on 13.09.2017.
 */
public class MailPageSteps {
    MailPage mailPage = new MailPage(getDriver());

    @Step("Переход на страницу почты")
    public void getMailUrl() {
        BaseSteps.getDriver().get(mailUrl);
    }

    @Step("Поле {0} заполняется значением {2}")
    public void fillField(WebElement element, String value) {
        new MailPage(getDriver()).fillField(element, value);
    }

    @Step("Ввод логина")
    public void mailLogin() {
        fillField(mailPage.login, BaseSteps.login);
        mailPage.identifierNext.click();
    }

    @Step("Ввод пароля")
    public void mailPassword() {
        fillField(mailPage.password, BaseSteps.passwordMail);
        mailPage.passwordNext.click();
    }

    @Step("Выбор и нажатие на письмо от ebay")
    public void openMail(){
        new MailPage(getDriver()).notOpenedMail.click();
    }

    @Step("Нажатие кнопки подтвердить в письме")
    public void assertButton(){
        new MailPage(getDriver()).notOpenedMail.click();
    }

}
