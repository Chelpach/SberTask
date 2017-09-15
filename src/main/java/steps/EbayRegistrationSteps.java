package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import packagePages.EbayRegistrationPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static steps.BaseSteps.getDriver;


public class EbayRegistrationSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        new EbayRegistrationPage(getDriver()).fillField(field, value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> fillField(k, v));
    }

    @Step("Выполнено нажатие на ссылку «Зарегистрируйтесь»")
    public void clickRegisterButton() {
        new EbayRegistrationPage(getDriver()).signUpButton.click();
    }

    @Step("Нажать на кнопку 'Заменить учётную запись'")
    public void clickReqinterButton() {
        new EbayRegistrationPage(getDriver()).reginter.click();
    }
}
