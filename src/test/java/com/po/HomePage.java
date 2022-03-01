package com.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    public static final String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String HOME_PAGE_URL_ASSERT = "https://stellarburgers.nomoreparties.site/";

    //кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement headerAccountButton;

    //кнопка "Войти в аккаунт"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement toAccountButton;

    //кнопка "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']//ancestor::div[contains(@class, 'tab_tab__1SPyG')]")
    private SelenideElement bunsButton;

    //кнопка "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']//ancestor::div[contains(@class, 'tab_tab__1SPyG')]")
    private SelenideElement saucesButton;

    //кнопка "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']//ancestor::div[contains(@class, 'tab_tab__1SPyG')]")
    private SelenideElement ingredientsButton;

    //заголовок раздела "Булки"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(), 'Булки')]")
    private SelenideElement bunsHeader;

    //заголовок раздела "Соусы"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(), 'Соусы')]")
    private SelenideElement saucesHeader;

    //заголовок раздела "Начинки"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(), 'Начинки')]")
    private SelenideElement ingredientsHeader;

    //клик по кнопке "Войти в аккаунт"
    @Step("Клик по кнопке Войти в аккаунт на главной")
    public void clickToAccountButton() {
        toAccountButton.click();
    }

    //клик по кнопке "Личный кабинет" в шапке
    @Step("Клик по кнопке Личный кабинет в шапке на главной")
    public void clickHeaderAccountButton() { headerAccountButton.click(); }

    //клик по кнопке "Булки"
    @Step("Клик по кнопке Булки в конструкторе на главной")
    public void clickBunsButton() {
        bunsButton.click();
    }

    //поиск кнопки "Булки"
    @Step("Клик по кнопке Булки в конструкторе на главной")
    public SelenideElement getBunsButton() {
        return bunsButton;
    }

    //клик по кнопке "Соусы в конструкторе"
    @Step("Клик по кнопке Соусы на главной")
    public void clickSaucesButton() {
        saucesButton.click();
    }

    //поиск кнопки "Соусы"
    @Step("Клик кнопки Соусы в конструкторе на главной")
    public SelenideElement getSaucesButton() {
        return saucesButton;
    }

    //клик по кнопке "Начинки"
    @Step("Клик по кнопке Начинки в конструкторе на главной")
    public void clickIngredientsButton() { ingredientsButton.click(); }

    //поиск кнопки "Соусы"
    @Step("Поиск кнопки Соусы в конструкторе на главной")
    public SelenideElement getIngredientsButton() {
        return ingredientsButton;
    }

}
