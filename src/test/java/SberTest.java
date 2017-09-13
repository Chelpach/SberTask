import org.testng.annotations.Test;
import packagePages.*;
import steps.*;

import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SberTest extends BaseSteps {
    BaseSteps baseSteps = new BaseSteps();
    EbayMainPageSteps ebayMainPageSteps = new EbayMainPageSteps();
    EbayRegistrationSteps ebayRegistrationSteps = new EbayRegistrationSteps();
    MailPageSteps mailPageSteps = new MailPageSteps();
    SignInPageSteps signInPageSteps = new SignInPageSteps();
    HashMap<String, String> testData = new HashMap<>();


    @Test(description = "Регистрация на ebay.com")
    public void testScenario1() throws Exception {
        testData.put("Имя", "Дмитрий");
        testData.put("Фамилия", "Дмитриев");
        testData.put("Адрес эл. почты", baseSteps.login);
        testData.put("Пароль", baseSteps.passwordApp);

        ebayMainPageSteps.clickRegisterLink();
        if(new EbayRegistrationPage(getDriver()).phoneFlagComp1.isDisplayed()){
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
