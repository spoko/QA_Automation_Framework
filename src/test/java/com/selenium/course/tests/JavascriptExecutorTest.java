package com.selenium.course.tests;

import com.selenium.course.tests.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavascriptExecutorTest extends TestUtil {
    //private WebDriver driver = setUp();

//    @BeforeTest //This cames from TestNG
//    public void setUp(){
//        WebDriverManager.chromedriver().setup(); //this download the needed web driver
//        driver = new ChromeDriver(); //creates the session and open the browser
//    }
//
//    @AfterTest //This cames from TestNG
//    public void tearDown(){
//        //driver.close(); closes only the current drive not closing the session
//        driver.quit(); //closing and killing the session
//    }

    @Test //This cames from TestNG
    public void logInWithJavascriptAction() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();

        WebElement productsMainLabel = driver.findElement(By.xpath("//span[text()='Products']"));
        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

        Assert.assertTrue(productsMainLabel.isDisplayed());
        Assert.assertTrue(shoppingCartLink.isDisplayed());
        Thread.sleep(5000);

        JavascriptExecutor script = (JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView",
                driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']")));

        Thread.sleep(5000);
    }
}
