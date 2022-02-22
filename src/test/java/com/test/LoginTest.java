package com.test;

import com.UserOperations;
import com.model.Success;
import com.model.User;
import com.po.HomePage;
import com.po.RegistrationPage;
import org.junit.After;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginTest {

        UserOperations userOperations = new UserOperations();

        @After
        public void closeStage() {
            closeWebDriver();
            //userOperations.delete();
        }

        @Test
        public void checkCustomerRegistrationTest() {
            RegistrationPage registrationPage =
                    open(HomePage.HOME_PAGE_URL,
                            RegistrationPage.class);

            Map<String, String> userData = userOperations.register();
            System.out.println(userData.get("password"));
            System.out.println(userData.get("email"));

            //System.out.println(userOperations.getEmail() + responseData.getPassword());
            //registrationPage.fillRegistrationForm(credentials.getName(), credentials.getEmail(), credentials.getPassword());
            //registrationPage.clickRegisterButton();

            //userOperations.login(credentials.getEmail(), credentials.getPassword());
            //assertTrue(Success.isSuccess());

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
