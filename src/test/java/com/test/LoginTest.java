package com.test;

import com.UserOperations;
import com.model.Tokens;
import com.po.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)

public class LoginTest {

        UserOperations userOperations;

        private final String driver;

        public LoginTest(String driver) {
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

            userOperations = new UserOperations();
        }

        @After
        public void tearDown() {
            userOperations.delete();
            Tokens.clearTokens();
            closeWebDriver();
        }

        @Test
        @DisplayName("Проверка авторизации после клика по кнопке Войти в аккаунт")
        public void checkCustomerLoginByToAccountButtonTest() {

            HomePage homePage =
                    open(HomePage.HOME_PAGE_URL,
                            HomePage.class);

            homePage.clickToAccountButton();

            LoginPage loginPage = page(LoginPage.class);
            String email = loginPage.fillLoginForm();
            loginPage.clickLoginButton();

            homePage.clickHeaderAccountButton();

            AccountPage accountPage = page(AccountPage.class);
            accountPage.getEmailField().shouldHave(value(email));

        }

    @Test
    @DisplayName("Проверка авторизации после клика по кнопке Личный кабинет на главной")
    public void checkCustomerLoginByHeaderAccountButtonTest() {

        HomePage homePage =
                open(HomePage.HOME_PAGE_URL,
                        HomePage.class);

        homePage.clickHeaderAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        String email = loginPage.fillLoginForm();
        loginPage.clickLoginButton();

        homePage.clickHeaderAccountButton();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.getEmailField().shouldHave(value(email));

    }

    @Test
    @DisplayName("Проверка авторизации после клика по кнопке Войти на странице регистрации")
    public void checkCustomerLoginByRegistrationPageLoginButtonTest() {

        RegistrationPage registrationPage =
                open(RegistrationPage.REGISTRATION_PAGE_URL,
                        RegistrationPage.class);

        registrationPage.clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        String email = loginPage.fillLoginForm();
        loginPage.clickLoginButton();

        HomePage homePage = page(HomePage.class);
        homePage.clickHeaderAccountButton();

        AccountPage accountPage = page(AccountPage.class);
        accountPage.getEmailField().shouldHave(value(email));

    }

    @Test
    @DisplayName("Проверка авторизации после клика по кнопке Войти на странице восстановления пароля")
    public void checkCustomerLoginByRestorePasswordPageLoginButtonTest() {

        RestorePasswordPage restorePasswordPage =
                open(RestorePasswordPage.RESTORE_PASSWORD_PAGE_URL,
                        RestorePasswordPage.class);

        restorePasswordPage.clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        String email = loginPage.fillLoginForm();
        loginPage.clickLoginButton();

        HomePage homePage = page(HomePage.class);
        homePage.clickHeaderAccountButton();

        AccountPage accountPage = page(AccountPage.class);
        accountPage.getEmailField().shouldHave(value(email));

    }


}
