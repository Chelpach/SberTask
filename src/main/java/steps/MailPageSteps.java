package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import packagePages.BasePage;
import packagePages.EbayRegistrationPage;
import packagePages.MailPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.*;

/**
 * Created by user on 13.09.2017.
 */
public class MailPageSteps {

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
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(new MailPage(getDriver()).login));
        new MailPage(getDriver()).login.click();
        new MailPage(getDriver()).login.sendKeys(BaseSteps.login);
        new MailPage(getDriver()).identifierNext.click();
    }

    @Step("Ввод пароля")
    public void mailPassword() {
        new MailPage(getDriver()).password.click();
        new MailPage(getDriver()).password.sendKeys(BaseSteps.passwordMail);
        new MailPage(getDriver()).passwordNext.click();
    }

    @Step("Выбор и нажатие на письмо от ebay")
    public void openMail() {
        new MailPage(getDriver()).notOpenedMail.click();
    }

    @Step("Нажатие кнопки подтвердить в письме")
    public void assertButton() {
        new MailPage(getDriver()).accertButton.click();
    }

}
