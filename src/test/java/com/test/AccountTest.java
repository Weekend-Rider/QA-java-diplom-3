package com.test;

import com.UserOperations;
import com.codeborne.selenide.WebDriverRunner;
import com.po.*;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class AccountTest {

        UserOperations userOperations = new UserOperations();

        @After
        public void tearDown() {
            userOperations.delete();
            closeWebDriver();
        }

        @Test
        public void checkClickHeaderAccountButtonOpensAccountPageTest() {

            LoginPage loginPage =
                    open(LoginPage.LOGIN_PAGE_URL,
                            LoginPage.class);

            loginPage.fillLoginForm();
            loginPage.clickLoginButton();

            HomePage homePage = page(HomePage.class);
            homePage.clickHeaderAccountButton();

            AccountPage accountPage = page(AccountPage.class);
            accountPage.getProfileButton().shouldBe(visible);

            String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals("https://stellarburgers.nomoreparties.site/account/profile", actualUrl);

        }

    @Test
    public void checkClickConstructorButtonOpensHomePage() {

        LoginPage loginPage =
                open(LoginPage.LOGIN_PAGE_URL,
                        LoginPage.class);

        loginPage.fillLoginForm();
        loginPage.clickLoginButton();

        HomePage homePage = page(HomePage.class);
        homePage.clickHeaderAccountButton();

        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickConstructorButton();

        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://stellarburgers.nomoreparties.site/", actualUrl);

    }

    @Test
    public void checkClickHeaderLogoOpensHomePage() {

        LoginPage loginPage =
                open(LoginPage.LOGIN_PAGE_URL,
                        LoginPage.class);

        loginPage.fillLoginForm();
        loginPage.clickLoginButton();

        HomePage homePage = page(HomePage.class);
        homePage.clickHeaderAccountButton();

        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickHeaderLogo();

        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://stellarburgers.nomoreparties.site/", actualUrl);

    }

    @Test
    public void checkClickExitButtonTestLogoutUser() {

        LoginPage loginPage =
                open(LoginPage.LOGIN_PAGE_URL,
                        LoginPage.class);

        loginPage.fillLoginForm();
        loginPage.clickLoginButton();

        HomePage homePage = page(HomePage.class);
        homePage.clickHeaderAccountButton();

        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickLogoutButton();

        loginPage.clickHeaderAccountButton();

        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://stellarburgers.nomoreparties.site/login", actualUrl);

    }


}
