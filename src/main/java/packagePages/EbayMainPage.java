package packagePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.09.2017.
 */
public class EbayMainPage extends BasePage {
    @FindBy(css = "#gh-ug-flex>a")
    public WebElement signUp;

    @FindBy(css = "#gh-ac")
    public WebElement search;

    @FindBy(css = "#gh-btn")
    public WebElement findButton;

    @FindBy(css = "#ListViewInner")
    public WebElement listViewInner;

    @FindBy(xpath = "//*[@class='gh-eb-arw gh-sprRetina']")
    public WebElement loginMenu;

    @FindBy(css = "#gh-uo>a")
    public WebElement quit;


    public EbayMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int assertNumbersOfItems() {
        List<WebElement> list = new ArrayList<WebElement>();
        list = listViewInner.findElements(By.className("lvtitle"));
        System.out.println(list.size());
        return list.size();
    }

}
