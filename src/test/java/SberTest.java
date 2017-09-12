import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import packagePages.EbayMainPage;

/**
 * Created by user on 12.09.2017.
 */
public class SberTest extends BaseTest {
    @Test
    public void testScenario1() throws Exception {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        EbayMainPage ebayMainPage = new EbayMainPage(driver);

    }
}
