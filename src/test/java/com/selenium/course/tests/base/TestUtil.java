package com.selenium.course.tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestUtil {
    //Selenium
    private WebDriver driver;

    @BeforeTest //This cames from TestNG
    public WebDriver setUp(){
        WebDriverManager.chromedriver().setup(); //this download the needed web driver
        driver = new ChromeDriver(); //creates the session and open the
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    @AfterTest //This cames from TestNG
    public void tearDown(){
        //driver.close(); closes only the current drive not closing the session
        driver.quit(); //closing and killing the session
    }
}
