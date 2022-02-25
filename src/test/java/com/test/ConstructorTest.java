package com.test;

import com.codeborne.selenide.Condition;
import com.po.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Point;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ConstructorTest {

        @After
        public void tearDown() {
            closeWebDriver();
        }

        @Test
        public void checkScrollToBunsTest() {

            HomePage homePage =
                    open(HomePage.HOME_PAGE_URL,
                            HomePage.class);

            homePage.clickIngredientsButton();
            homePage.clickBunsButton();
            homePage.getBunsButton().shouldHave(cssClass("tab_tab_type_current__2BEPc"));

        }

    @Test
    public void checkScrollToSaucesTest() {

        HomePage homePage =
                open(HomePage.HOME_PAGE_URL,
                        HomePage.class);

        homePage.clickSaucesButton();
        homePage.getSaucesButton().shouldHave(cssClass("tab_tab_type_current__2BEPc"));

    }

    @Test
    public void checkScrollToIngredientsTest() {

        HomePage homePage =
                open(HomePage.HOME_PAGE_URL,
                        HomePage.class);

        homePage.clickIngredientsButton();
        homePage.getIngredientsButton().shouldHave(cssClass("tab_tab_type_current__2BEPc"));


    }

}
