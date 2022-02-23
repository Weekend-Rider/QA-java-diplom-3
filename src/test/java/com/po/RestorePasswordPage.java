package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage {

    public static final String RESTORE_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement loginButton;

    //клик по кнопке "Войти"
    public void clickLoginButton() {
        loginButton.click();
    }

}
