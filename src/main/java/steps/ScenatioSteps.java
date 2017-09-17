package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Если;

import java.util.HashMap;

/**
 * Created by user on 14.09.2017.
 */
public class ScenatioSteps {

    private EbayMainPageSteps ebayMainPageSteps = new EbayMainPageSteps();
    private EbayRegistrationSteps ebayRegistrationSteps = new EbayRegistrationSteps();
    private MailPageSteps mailPageSteps = new MailPageSteps();
    private SignInPageSteps signInPageSteps = new SignInPageSteps();


    @When("^выбран пункт меню 'Зарегистрируйтесь'$")
    public void clickRegisterLink() {
        ebayMainPageSteps.clickRegisterLink();
    }

    @Если("^активна более длинная форма$")
    public void checkForm(){
        ebayRegistrationSteps.checkForm();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> ebayRegistrationSteps.fillField(field, value));
    }
    //  public void fillFields(HashMap<String, String> value) {
    //      ebayRegistrationSteps.fillFields(value);
    //  }

    @When("^нажатие на кнопку \"Зарегистрировать\"$")
    public void clickRegisterButton() {
        ebayRegistrationSteps.clickRegisterButton();
    }

    @When("^нажатие на кнопку перегистрации$")
    public void clickReginterButton() {
        ebayRegistrationSteps.clickReqinterButton();
    }

    @When("^переход на страницу почты$")
    public void getMailUrl() {
        mailPageSteps.getMailUrl();
    }

    @When("^заполняется поле login и нажимается кнопка далее$")
    public void mailLogin() {
        mailPageSteps.mailLogin();
    }

    @When("^заполняется поле password и нажимается кнопка далее$")
    public void mailPassword() throws InterruptedException {
        Thread.sleep(1000);
        mailPageSteps.mailPassword();
    }

    @When("^открытие непрочитанного сообщения от ebay$")
    public void openMail() {
        mailPageSteps.openMail();
    }

    @When("^нажатие кнопки поддтвердить в письме$")
    public void assertButton() {
        mailPageSteps.assertButton();
    }

    @When("^переключение на другое окно$")
    public void switchWindow() {
        BaseSteps.switchWindow();
    }

    @When("^ввод логина на странице входа$")
    public void ebayLogin() {
        signInPageSteps.ebayLogin();
    }

    @When("^ввод пароля на странице входа$")
    public void ebayPassword() {
        signInPageSteps.ebayPassword();
    }

    @When("^нажатие кнопки подтвердить$")
    public void confirmPassword() {
        signInPageSteps.confirmPassowrd();
    }

    @When("^ввод в строку поиска значения \\\"(.+)\\\"$")
    public void search(String searchString) {
        ebayMainPageSteps.search(searchString);
    }

    @When("^нажатие кнопки поиск на главном экране$")
    public void pressFindButton() {
        ebayMainPageSteps.pressFindButton();
    }

    @Then("^проверка что количество выводимых товаров равно \\\"(.+)\\\"$")
    public void checkNumberOfGoods(int number) {
        ebayMainPageSteps.checkNumberOfGoods(number);
    }

    @When("^выход из учетной записи ebay.com$")
    public void quit() {
        ebayMainPageSteps.quit();
    }

    @Then("^проверка что выход произошел$")
    public void checkQuit() {
        ebayMainPageSteps.checkQuit();
    }
}
