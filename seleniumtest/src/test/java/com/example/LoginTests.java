package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.example.pages.LoginPage;
import com.example.utils.CredentialsLoader;
import org.junit.Assert;

/**
 * Login Tests for Swag Labs
 */
public class LoginTests {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void before() {
        // Apply Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void successfulStandardUserLogin() {
        String standardUser = CredentialsLoader.get("standardUser");

        loginPage.login(standardUser);

        Assert.assertEquals("The title: " + driver.getTitle() + " didn't equal \'Swag Labs\'.", "Swag Labs", driver.getTitle());
        loginPage.logout();
    }

    @Test
    public void lockedOutUserLogin() {
        String lockedOutUser = CredentialsLoader.get("lockedOutUser");

        loginPage.login(lockedOutUser);

        Assert.assertEquals( "Epic sadface: Sorry, this user has been locked out.", driver.findElement(loginPage.errorMessage).getText());
    }
}
