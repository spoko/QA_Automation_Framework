package com.selenium.course.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
    //Selenium
    private WebDriver driver;

    @BeforeTest //This cames from TestNG
    public void setUp(){
        WebDriverManager.chromedriver().setup(); //this download the needed web driver
        driver = new ChromeDriver(); //creates the session and open the browser
    }

    @AfterTest //This cames from TestNG
    public void tearDown(){
        //driver.close(); closes only the current drive not closing the session
        driver.quit(); //closing and killing the session
    }

    @Test //This cames from TestNG
    public void logIn() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");
        Thread.sleep(2000);

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(2000);

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();
        Thread.sleep(2000);


        WebElement productsMainLabel = driver.findElement(By.xpath("//span[text()='Products']"));
        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

        Assert.assertTrue(productsMainLabel.isDisplayed());
        Assert.assertTrue(shoppingCartLink.isDisplayed());
    }

    @Test //This cames from TestNG
    public void logInWithWrongUser(){
        driver.get("https://www.saucedemo.com/");

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user1");

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();

        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(wrongUserBtn.isDisplayed());
    }

}
