package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    protected WebDriver driver;

    public By headerContainer = By.id("header_container");
    public By title = By.className("title");
    public By sideBarMenu = By.id("react-burger-menu-btn");
    public By logoutLink = By.id("logout_sidebar_link");
    public By backToProductsLink = By.id("back-to-products");
    public By inventoryContainer = By.id("inventory_container");
    public By itemTitle = By.className("inventory_details_name");
    public By itemBikeLight = By.id("item_0_title_link");
    public By itemBoltTShirt = By.id("item_1_title_link");
    public By itemOnesie = By.id("item_2_title_link");
    public By itemRedTShirt = By.id("item_3_title_link");
    public By itemBackpack = By.id("item_4_title_link");
    public By itemFleeceJacket = By.id("item_5_title_link");
    public By itemPrice = By.className("inventory_details_price");
    
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
}
