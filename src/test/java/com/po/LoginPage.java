package com.po;

import com.UserOperations;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

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

    //кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement headerAccountButton;

    //заполнение формы авторизации
    @Step("Заполнение формы авторизации")
    public String fillLoginForm() {

        UserOperations userOperations = new UserOperations();

        Map<String, String> userData = userOperations.register();

        emailInputField.setValue(userData.get("email"));
        passwordInputField.setValue(userData.get("password"));

        return userData.get("email");
    }

    //клик по кнопке "Войти"
    @Step("Клик по кнопке Войти на странице авторизации")
    public void clickLoginButton() {
        loginButton.click();
    }

    //клик по кнопке "Личный кабинет"
    @Step("Клик по кнопке Личный кабинет на странице авторизации")
    public void clickHeaderAccountButton() {
        headerAccountButton.click();
    }

}
