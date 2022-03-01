package com.test;

import com.UserOperations;
import com.model.Success;
import com.model.Tokens;
import com.model.User;
import com.po.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class RegistrationTest {

        UserOperations userOperations;

        private final String driver;

        public RegistrationTest(String driver) {
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
        @DisplayName("Проверка регистрации покупателя")
        public void checkCustomerRegistrationTest() {
            RegistrationPage registrationPage =
                    open(RegistrationPage.REGISTRATION_PAGE_URL,
                            RegistrationPage.class);

            User credentials = userOperations.generateUser();

            registrationPage.fillRegistrationForm(credentials.getName(), credentials.getEmail(), credentials.getPassword());
            registrationPage.clickRegisterButton();

            userOperations.login(credentials.getEmail(), credentials.getPassword());
            assertTrue(Success.isSuccess());
        }

    @Test
    @DisplayName("Проверка ошибки при попытке регистрации с некорректным паролем")
    public void checkIncorrectPasswordErrorTest() {
        RegistrationPage registrationPage =
                open(RegistrationPage.REGISTRATION_PAGE_URL,
                        RegistrationPage.class);

        User credentials = userOperations.generateUser();

        registrationPage.fillRegistrationForm(credentials.getName(), credentials.getEmail(), "123");
        registrationPage.clickRegisterButton();

        registrationPage.getPasswordErrorMessage().shouldBe(visible);
    }

}
