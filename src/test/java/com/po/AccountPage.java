package com.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {

    public static final String ACCOUNT_PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //кнопка "Профиль"
    @FindBy(how = How.XPATH, using = ".//a[text()='Профиль']")
    private SelenideElement profileButton;

    //кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //логотип Stellar Burgers
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement headerLogo;

    //кнопка "Выйти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    //поле "email"
    @FindBy(how = How.XPATH, using = ".//li[2]/div/div/input")
    private SelenideElement emailField;

    //поиск поля "email"
    @Step("Поиск поля email на странице ЛК")
    public SelenideElement getEmailField() {
        return emailField;
    }

    //поиск кнопки "Профиль"
    @Step("Поиск кнопки Профиль на странице ЛК")
    public SelenideElement getProfileButton() {
        return profileButton;
    }

    //клик по кнопке "Конструктор"
    @Step("Клик по кнопке Конструктор на странице ЛК")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    //клик по логотипу
    @Step("Клик по логотипу на странице ЛК")
    public void clickHeaderLogo() {
        headerLogo.click();
    }

    //клик по кнопке "Выход"
    @Step("Клик по кнопке Выход")
    public void clickLogoutButton() {
        logoutButton.click();
    }

}
