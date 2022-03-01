package com.test;

import com.UserOperations;
import com.codeborne.selenide.WebDriverRunner;
import com.model.Tokens;
import com.po.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class AccountTest {

        UserOperations userOperations;

        private final String driver;

        public AccountTest(String driver) {
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
        @DisplayName("Проверка открытия ЛК при клике на кнопку Личный кабинет в шапке на главной")
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
            assertEquals(AccountPage.ACCOUNT_PROFILE_PAGE_URL, actualUrl);

        }

    @Test
    @DisplayName("Проверка открытия главной страницы при клике на кнопку Конструктор в ЛК")
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
        assertEquals(HomePage.HOME_PAGE_URL_ASSERT, actualUrl);

    }

    @Test
    @DisplayName("Проверка открытия главной страницы при клике на логотип в ЛК")
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
        assertEquals(HomePage.HOME_PAGE_URL_ASSERT, actualUrl);

    }

    @Test
    @DisplayName("Проверка выхода при клике на кнопку Выход в ЛК")
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
        assertEquals(LoginPage.LOGIN_PAGE_URL, actualUrl);

    }


}
