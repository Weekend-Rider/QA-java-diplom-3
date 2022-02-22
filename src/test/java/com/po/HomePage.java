package com.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    public static final String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site";


    //кнопка "Личный кабинет

    //кнопка "Войти в аккаунт"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement toAccountButton;

    //кнопка "Булки"
    //кнопка "Соусы"
    //кнопка "Начинки"
    //что-то идентифицирующее раздел "Булки"
    //что-то идентифицирующее раздел "Соусы"
    //что-то идентифицирующее раздел "Начинки"

    //клик по кнопке "Войти в аккаунт"
    public void clickToAccountButton() {
        toAccountButton.click();
    }

}
