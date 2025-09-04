package com.janitri.tests;

import com.janitri.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage login = new LoginPage(driver);
        Assert.assertFalse(login.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test
    public void testPasswordMaskedByDefault() {
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.isPasswordMasked(), "Password should be masked by default");
    }

    @Test
    public void testPasswordVisibilityToggle() {
        LoginPage login = new LoginPage(driver);
        login.enterPassword("dummyPassword");
        login.togglePasswordVisibility();
        Assert.assertFalse(login.isPasswordMasked(), "Password should be visible after toggle");
    }

    @Test
    public void testInvalidLoginShowsError() {
        LoginPage login = new LoginPage(driver);
        login.enterEmail("invalid@email.com");
        login.enterPassword("wrongpassword");
        login.clickLogin();
        Assert.assertTrue(login.getErrorMessage().contains("Invalid"), "Error message should show for invalid login");
    }

    @Test
    public void testUIElementsPresence() {
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.isLoginPageDisplayed(), "All UI elements should be present on login page");
    }
}
