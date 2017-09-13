import org.testng.annotations.Test;
import packagePages.*;
import steps.*;

import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SberTest extends BaseSteps{
    BaseSteps baseSteps = new BaseSteps();
    EbayMainPageSteps ebayMainPageSteps = new EbayMainPageSteps();
    EbayRegistrationSteps ebayRegistrationPage = new EbayRegistrationSteps();
    MailPageSteps mailPageSteps = new MailPageSteps();
    SignInPageSteps signInPageSteps = new SignInPageSteps();
    HashMap<String, String> testData = new HashMap<>();


    @Test(description = "Регистрация на ebay.com")
    public void testScenario1() throws Exception {
        testData.put("Имя", "Дмитрий");
        testData.put("Фамилия", "Дмитриев");
        testData.put("Адрес эл. почты", baseSteps.login);
        testData.put("Пароль", baseSteps.passwordApp);
        testData.put("Телефон", "4056664523");
        testData.put("Повторный ввод эл.почты", baseSteps.login);

        ebayMainPageSteps.clickRegisterLink();
        ebayRegistrationPage.fillFields(testData);
        ebayRegistrationPage.clickRegisterButton();
        mailPageSteps.getMailUrl();
        mailPageSteps.mailLogin();
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

        // EbayRegistrationPage ebayRegistrationPage = new EbayRegistrationPage(driver);

        // ebayRegistrationPage.fillField(ebayRegistrationPage.email, login);
        // ebayRegistrationPage.fillField(ebayRegistrationPage.firstname, "Дмитрий");
        // ebayRegistrationPage.fillField(ebayRegistrationPage.lastname, "Дмитриев");
        //  ebayRegistrationPage.fillField(ebayRegistrationPage.password, passwordApp);
        //    ebayRegistrationPage.fillFieldIfPresent(ebayRegistrationPage.remail, login);
        //     ebayRegistrationPage.fillFieldIfPresent(ebayRegistrationPage.phoneFlagComp1, "4056664523");


        //ebayRegistrationPage.signUpButton.click();
        // ebayRegistrationPage.reginter.click();

        //   driver.get(mailUrl);
        //    driver.manage().window().maximize();

        //     MailPage mailPage = new MailPage(driver);
        //     ebayRegistrationPage.fillField(mailPage.login, login);
        // mailPage.identifierNext.click();
        // Thread.sleep(1000);
        // mailPage.password.click();
        //    ebayRegistrationPage.fillField(mailPage.password, passwordMail);

        //   mailPage.passwordNext.click();
        //   mailPage.notOpenedMail.click();

        //  mailPage.accertButton.click();
        // SignInPage signInPage = new SignInPage(driver);

        //   switchWindow();

        /// signInPage.fillField(signInPage.login, login);
        //  signInPage.fillField(signInPage.password, passwordApp);
        //  signInPage.enterButton.click();

        //   signInPage.fillField(ebayMainPage.search, "blackberry");
        //  ebayMainPage.findButton.click();

        //  assertEquals(50, ebayMainPage.assertNumbersOfItems());

        // ebayMainPage.loginMenu.click();
        // ebayMainPage.quit.click();

        //   assertTrue(ebayMainPage.signUp.isDisplayed());
    }
}
