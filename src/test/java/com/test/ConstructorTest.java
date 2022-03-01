package com.test;

import com.po.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)

public class ConstructorTest {

    private final String driver;

    public ConstructorTest(String driver) {
        this.driver = driver;
    }

    @Parameterized.Parameters
    public static Object[][] getDriver() {
        return new Object[][] {
                { "src/resources/yandexdriver.exe" },
                { "src/resources/chromedriver.exe"}
        };
    }

        @Before
        public void setDriver() {
            System.setProperty("webdriver.chrome.driver", driver);
        }

        @After
        public void tearDown() {
            closeWebDriver();
        }

        @Test
        @DisplayName("Проверка перехода к разделу Булки")
        public void checkScrollToBunsTest() {

            HomePage homePage =
                    open(HomePage.HOME_PAGE_URL,
                            HomePage.class);

            homePage.clickIngredientsButton();
            homePage.clickBunsButton();
            homePage.getBunsButton().shouldHave(cssClass("tab_tab_type_current__2BEPc"));

        }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    public void checkScrollToSaucesTest() {

        HomePage homePage =
                open(HomePage.HOME_PAGE_URL,
                        HomePage.class);

        homePage.clickSaucesButton();
        homePage.getSaucesButton().shouldHave(cssClass("tab_tab_type_current__2BEPc"));

    }

    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    public void checkScrollToIngredientsTest() {

        HomePage homePage =
                open(HomePage.HOME_PAGE_URL,
                        HomePage.class);

        homePage.clickIngredientsButton();
        homePage.getIngredientsButton().shouldHave(cssClass("tab_tab_type_current__2BEPc"));


    }

}
