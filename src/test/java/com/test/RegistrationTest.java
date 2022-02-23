package com.test;
import com.UserOperations;
import com.model.Success;
import com.model.User;
import com.po.RegistrationPage;

import org.junit.After;
import org.junit.Test;

import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {

        UserOperations userOperations = new UserOperations();

        @After
        public void tearDown() {
            userOperations.delete();
            closeWebDriver();
        }

        @Test
        public void checkCustomerRegistrationTest() {
            RegistrationPage registrationPage =
                    open(RegistrationPage.REGISTRATION_PAGE_URL,
                            RegistrationPage.class);

            User credentials = userOperations.generateUser();

            System.out.println(credentials.getEmail() + credentials.getPassword());
            registrationPage.fillRegistrationForm(credentials.getName(), credentials.getEmail(), credentials.getPassword());
            registrationPage.clickRegisterButton();

            userOperations.login(credentials.getEmail(), credentials.getPassword());
            assertTrue(Success.isSuccess());

            //open("https://qa-scooter.praktikum-services.ru/account"); //не канает, надо кликать кнопку ЛК
            //String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            //assertEquals("https://qa-scooter.praktikum-services.ru/account", actualUrl);

            }

    @Test
    public void checkIncorrectPasswordErrorTest() {
        RegistrationPage registrationPage =
                open(RegistrationPage.REGISTRATION_PAGE_URL,
                        RegistrationPage.class);

        User credentials = userOperations.generateUser();

        registrationPage.fillRegistrationForm(credentials.getName(), credentials.getEmail(), "123");
        registrationPage.clickRegisterButton();

        registrationPage.getPasswordErrorMessage().shouldBe(visible);

        //open("https://qa-scooter.praktikum-services.ru/account"); //не канает, надо кликать кнопку ЛК
        //String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        //assertEquals("https://qa-scooter.praktikum-services.ru/account", actualUrl);

    }


/*
        @Test
        public void clickSamokatLogoOpensHomePage() {
            HomePage homePage =
                    open(HomePage.HOME_PAGE_URL,
                            HomePage.class);
            homePage.clickSamokatLogo();
            String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals("https://qa-scooter.praktikum-services.ru/", actualUrl);
        }

        @Test
        public void clickYandexLogoOpensNewTabWithYandex() {
            HomePage homePage =
                    open(HomePage.HOME_PAGE_URL,
                            HomePage.class);
            homePage.clickYandexLogo();
            switchTo().window(1);
            String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals("https://yandex.ru/", actualUrl);
        }

    }*/

}
