
import org.junit.Test;
import packagePages.*;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;
import java.util.HashMap;

public class SberTe extends BaseSteps {
    BaseSteps baseSteps = new BaseSteps();
    EbayMainPageSteps ebayMainPageSteps = new EbayMainPageSteps();
    EbayRegistrationSteps ebayRegistrationSteps = new EbayRegistrationSteps();
    MailPageSteps mailPageSteps = new MailPageSteps();
    SignInPageSteps signInPageSteps = new SignInPageSteps();
    HashMap<String, String> testData = new HashMap<>();

@Title("Регистрация на ebay.com")
    @Test
    public void testScenario1() throws Exception {
        testData.put("Имя", "Дмитрий");
        testData.put("Фамилия", "Дмитриев");
        testData.put("Адрес эл. почты", baseSteps.login);
        testData.put("Пароль", baseSteps.passwordApp);

        ebayMainPageSteps.clickRegisterLink();
        if(new EbayRegistrationPage(getDriver()).isElementPresent(new EbayRegistrationPage(getDriver()).phoneFlagComp1)){
            testData.put("Мобильный телефон", "4056664524");
            testData.put("Введите адрес эл. почты еще раз", baseSteps.login);
        }
        ebayRegistrationSteps.fillFields(testData);
        ebayRegistrationSteps.clickRegisterButton();
        mailPageSteps.getMailUrl();
        mailPageSteps.mailLogin();
        Thread.sleep(1000);
        mailPageSteps.mailPassword();
        mailPageSteps.openMail();
        mailPageSteps.assertButton();
        baseSteps.switchWindow();
        //при переходе по старой ссылке просит зарегистрироваться
        signInPageSteps.ebayLogin();
        signInPageSteps.ebayPassword();
        signInPageSteps.confirmPassowrd();
        ebayMainPageSteps.search("blackberry");
        ebayMainPageSteps.pressFindButton();
        ebayMainPageSteps.checkNumberOfGoods(50);
        ebayMainPageSteps.quit();
        ebayMainPageSteps.checkQuit();
    }
}
