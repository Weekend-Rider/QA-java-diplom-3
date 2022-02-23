package com.test;

import com.UserOperations;
import com.po.*;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginTest {

        UserOperations userOperations = new UserOperations();

        @After
        public void tearDown() {
            userOperations.delete();
            closeWebDriver();
        }

        @Test
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
