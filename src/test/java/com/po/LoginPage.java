package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    //поле email
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/div/input[@name='name']")
    private SelenideElement emailInputField;

    //поле пароль
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/div/input[@name='Пароль']")
    private SelenideElement passwordInputField;

    //кнопка "Войти"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement loginButton;

    //заполнение формы авторизации
    public void fillLoginForm(String email, String password) {
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
    }

    //клик по кнопке "Войти"
    public void clickLoginButton() {
        loginButton.click();
    }

}
