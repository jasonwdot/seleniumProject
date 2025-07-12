package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.Assert;

public class LoginPage {
    protected WebDriver driver;
    private InventoryPage inventoryPage;

    public String url = "https://www.saucedemo.com/";
    public By usernameTextBox = By.id("user-name");
    public By passwordTextBox = By.id("password");
    public By loginButton = By.id("login-button");
    public By errorMessage = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        inventoryPage = new InventoryPage(driver);
    }

    public void login(String user, String password) {
        driver.get(url);
        if(password == null) password = "secret_sauce";
        driver.findElement(usernameTextBox).sendKeys(user);
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void login(String user) {
        driver.get(url);
        driver.findElement(usernameTextBox).sendKeys(user);
        driver.findElement(passwordTextBox).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }

    public void logout() {
        driver.findElement(inventoryPage.sideBarMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(inventoryPage.logoutLink));
        driver.findElement(inventoryPage.logoutLink).click();
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }
}
