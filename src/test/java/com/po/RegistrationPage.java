package com.po;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    //поле имя
    @FindBy(how = How.XPATH, using = ".//fieldset[1]/div/div/input")
    private SelenideElement nameInputField;

    //поле email
    @FindBy(how = How.XPATH, using = ".//fieldset[2]/div/div/input")
    private SelenideElement emailInputField;

    //поле пароль
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/div/input[@name='Пароль']")
    private SelenideElement passwordInputField;

    //кнопка "Зарегистрироваться"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement registerButton;

    //сообщение об ошибке "некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement passwordErrorMessage;

    //кнопка "Войти"
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement loginButton;

    //заполнение формы регистрации
    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(String name, String email, String password) {

        nameInputField.setValue(name);
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
    }

    //клик по кнопке "Зарегистрироваться"
    @Step("Клик по кнопке Зарегистрироваться на старнице регистрации")
    public void clickRegisterButton() {
        registerButton.click();
    }

    //поиск элемента с текстом ошибки "некорректный пароль"
    @Step("Поиск элемента с текстом ошибки на старнице регистрации")
    public SelenideElement getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    //клик по кнопке "Войти"
    @Step("Клик по кнопке Войти на старнице регистрации")
    public void clickLoginButton() {
        loginButton.click();
    }


}
