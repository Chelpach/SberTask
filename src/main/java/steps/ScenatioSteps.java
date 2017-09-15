package steps;

import cucumber.api.java.en.When;

import java.util.HashMap;

/**
 * Created by user on 14.09.2017.
 */
public class ScenatioSteps {

    EbayMainPageSteps ebayMainPageSteps=new EbayMainPageSteps();
    EbayRegistrationSteps ebayRegistrationSteps=new EbayRegistrationSteps();


    @When("^выбран пункт меню 'Зарегистрируйтесь'$")
    public void clickRegisterLink(){
        ebayMainPageSteps.clickRegisterLink();
    }

    @When("^заполняются поля \\\"(.+)\\\"$")
    public void fillFields(HashMap<String,String> value){
        ebayRegistrationSteps.fillFields(value);
    }

    @When("^нажатие на кнопку \"Зарегистрировать\"$")
    public void clickRegisterButton(){
        ebayRegistrationSteps.clickRegisterButton();
    }

}
