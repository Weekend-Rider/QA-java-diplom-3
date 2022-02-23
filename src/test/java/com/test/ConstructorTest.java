package com.test;

import com.codeborne.selenide.Condition;
import com.po.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Point;

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

            homePage.clickSaucesButton();
            homePage.getSaucesHeader().hover();
            homePage.clickBunsButton();
            homePage.getBunsHeader().hover().shouldBe(Condition.visible);

        }

    @Test
    public void checkScrollToSaucesTest() {

        HomePage homePage =
                open(HomePage.HOME_PAGE_URL,
                        HomePage.class);

        homePage.clickSaucesButton();
        homePage.getSaucesHeader().hover().shouldBe(Condition.visible);

    }

    @Test
    public void checkScrollToIngredientsTest() {

        HomePage homePage =
                open(HomePage.HOME_PAGE_URL,
                        HomePage.class);

        homePage.clickIngredientsButton();
       // sleep(5000);

        Point header = homePage.getIngredientsHeader().getLocation();
        System.out.println(header.getY());

    }

}
