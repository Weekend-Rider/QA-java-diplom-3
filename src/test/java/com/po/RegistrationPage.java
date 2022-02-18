package com.po;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

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
    public void fillRegistrationForm(String name, String email, String password) {
        nameInputField.setValue(name);
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
    }

    //клик по кнопке "Зарегистрироваться"
    public void clickRegisterButton() {
        registerButton.click();
    }
}
