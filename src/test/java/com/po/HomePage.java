package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    public static final String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site";

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
    public void clickToAccountButton() {
        toAccountButton.click();
    }

    //клик по кнопке "Личный кабинет" в шапке
    public void clickHeaderAccountButton() { headerAccountButton.click(); }

    //клик по кнопке "Булки"
    public void clickBunsButton() {
        bunsButton.click();
    }

    //поиск кнопки "Булки"
    public SelenideElement getBunsButton() {
        return bunsButton;
    }

    //поиск заголовка "Булки"
    public SelenideElement getBunsHeader() {
        return bunsHeader;
    }

    //клик по кнопке "Соусы"
    public void clickSaucesButton() {
        saucesButton.click();
    }

    //поиск кнопки "Соусы"
    public SelenideElement getSaucesButton() {
        return saucesButton;
    }

    //поиск заголовка "Соусы"
    public SelenideElement getSaucesHeader() {
        return saucesHeader;
    }

    //клик по кнопке "Начинки"
    public void clickIngredientsButton() { ingredientsButton.click(); }

    //поиск кнопки "Соусы"
    public SelenideElement getIngredientsButton() {
        return ingredientsButton;
    }

    //поиск заголовка "Начинки"
    public SelenideElement getIngredientsHeader() { return ingredientsHeader; }

}
