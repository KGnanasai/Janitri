package com.janitri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By passwordToggle = By.xpath("//button[@aria-label='toggle password visibility']");
    private By errorMsg = By.xpath("//p[contains(@class,'Mui-error')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isPasswordMasked() {
        String type = driver.findElement(passwordField).getAttribute("type");
        return type.equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(passwordToggle).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(emailField).isDisplayed() &&
               driver.findElement(passwordField).isDisplayed() &&
               driver.findElement(loginButton).isDisplayed();
    }
}
