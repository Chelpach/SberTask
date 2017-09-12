import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import packagePages.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SberTest extends BaseTest {
    @Test
    public void testScenario1() throws Exception {

        driver.get(baseUrl);
        driver.manage().window().maximize();

        EbayMainPage ebayMainPage = new EbayMainPage(driver);
        ebayMainPage.signUp.click();

        EbayRegistrationPage ebayRegistrationPage = new EbayRegistrationPage(driver);

        BasePage.fillField(ebayRegistrationPage.email, login);
        BasePage.fillField(ebayRegistrationPage.firstname, "Дмитрий");
        BasePage.fillField(ebayRegistrationPage.lastname, "Дмитриев");
        BasePage.fillField(ebayRegistrationPage.password, passwordApp);
        if (ebayRegistrationPage.remail.isEnabled()) {
            BasePage.fillField(ebayRegistrationPage.remail, login);
        }
        if (ebayRegistrationPage.phoneFlagComp1.isEnabled()) {
            BasePage.fillField(ebayRegistrationPage.phoneFlagComp1, "4056664522");
        }

        ebayRegistrationPage.signUpButton.click();
        ebayRegistrationPage.reginter.click();

        driver.get(mailUrl);
        driver.manage().window().maximize();

        MailPage mailPage = new MailPage(driver);
        BasePage.fillField(mailPage.login, login);
        mailPage.identifierNext.click();
        Thread.sleep(1000);
        mailPage.password.click();
        BasePage.fillField(mailPage.password, passwordMail);

        mailPage.passwordNext.click();
        mailPage.notOpenedMail.click();

        mailPage.accertButton.click();
        SignInPage signInPage = new SignInPage(driver);

        switchWindow();

        BasePage.fillField(signInPage.login, login);
        BasePage.fillField(signInPage.password, passwordApp);
        signInPage.enterButton.click();

        BasePage.fillField(ebayMainPage.search, "blackberry");
        ebayMainPage.findButton.click();

        assertEquals(50, ebayMainPage.assertNumbersOfItems());

        ebayMainPage.quit.click();

        assertTrue(ebayMainPage.signUp.isDisplayed());
    }
}
