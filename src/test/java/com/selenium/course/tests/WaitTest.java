package com.selenium.course.tests;

import com.selenium.course.tests.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class WaitTest extends TestUtil {

    @Test//This cames from TestNG
    public void unsuccessfulLogin(){
        //before using Explicit wait reset the implicit one:
        driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS.toSeconds(5),TimeUnit.SECONDS);
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(5));

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        //Explicit Wait
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("login-button"))));
        //after finished using Explicit wait set back the implicit one:
        driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS.toSeconds(5), TimeUnit.SECONDS);
        loginBtn.click();

        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(wrongUserBtn.isDisplayed());
    }

    @Test//This cames from TestNG
    public void unsuccessfulLoginFluentWait(){
        //before using Explicit wait reset the implicit one:
        driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS.toSeconds(5), TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS.toSeconds(5), TimeUnit.SECONDS);
        loginBtn.click();

        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(wrongUserBtn.isDisplayed());
    }
}
