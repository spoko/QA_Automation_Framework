package com.selenium.course.tests;

import com.selenium.course.tests.base.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class WaitTest extends TestUtil {
    private WebDriver driver = setUp();

//    @BeforeTest //This cames from TestNG
//    public void setUp(){
//        WebDriverManager.chromedriver().setup(); //this download the needed web driver
//        driver = new ChromeDriver(); //creates the session and open the
//        //Implicit Wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
//    @AfterTest //This cames from TestNG
//    public void tearDown(){
//        //driver.close(); closes only the current drive not closing the session
//        driver.quit(); //closing and killing the session
//    }

    @Test//This cames from TestNG
    public void unsuccessfulLogin(){
        driver.get("https://www.saucedemo.com/");
        //before using Explicit wait reset the implicit one:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        //Explicit Wait
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("login-button"))));
        //after finished using Explicit wait set back the implicit one:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginBtn.click();

        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(wrongUserBtn.isDisplayed());
    }

    @Test//This cames from TestNG
    public void unsuccessfulLoginFluentWait(){
        driver.get("https://www.saucedemo.com/");
        //before using Explicit wait reset the implicit one:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        //Fluent
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        //Explicit Wait
        fluentWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("login-button"))));
        //after finished using Explicit wait set back the implicit one:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginBtn.click();

        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(wrongUserBtn.isDisplayed());
    }
}
