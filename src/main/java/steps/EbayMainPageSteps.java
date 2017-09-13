package steps;


import org.openqa.selenium.WebDriver;
import packagePages.EbayMainPage;

import packagePages.MailPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static steps.BaseSteps.getDriver;

/**
 * Created by user on 13.09.2017.
 */
public class EbayMainPageSteps {

    @Step("Выполнено нажатие на ссылку «Зарегистрируйтесь»")
    public void clickRegisterLink() {
        new EbayMainPage(getDriver()).signUp.click();
    }

    @Step("Ввод в строку поиска {0}")
    public void search(String value) {
        new EbayMainPage(getDriver()).search.sendKeys(value);
    }

    @Step("Нажатие на кнопку 'Найти'")
    public void pressFindButton() {
        new EbayMainPage(getDriver()).findButton.click();
    }


    @Step("На странице выведено {0} элеменов")
    public void checkNumberOfGoods(int number) {
        assertEquals(number, new EbayMainPage(getDriver()).assertNumbersOfItems());
    }

    @Step("Выход из учетной записи")
    public void quit() {
        new EbayMainPage(getDriver()).loginMenu.click();
        new EbayMainPage(getDriver()).quit.click();
    }

    @Step("На странице выведено {0} элеменов")
    public void checkQuit() {
        EbayMainPage ebayMainPage=new EbayMainPage(getDriver());
        assertTrue(ebayMainPage.signUp.isDisplayed());
    }

}
