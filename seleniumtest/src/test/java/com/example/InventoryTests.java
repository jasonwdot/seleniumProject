package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.example.pages.InventoryPage;
import com.example.pages.LoginPage;
import com.example.utils.CredentialsLoader;

import org.junit.Assert;

public class InventoryTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Before
    public void before() {
        // Apply Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void findAndClickOnBackpack() {
        String standardUser = CredentialsLoader.get("standardUser");
        loginPage.login(standardUser);

        Assert.assertEquals(loginPage.url + "inventory.html", driver.getCurrentUrl());
        driver.findElement(inventoryPage.itemBackpack).click();
        Assert.assertEquals("Sauce Labs Backpack", driver.findElement(inventoryPage.itemTitle).getText());
        loginPage.logout();
    }
    
}
