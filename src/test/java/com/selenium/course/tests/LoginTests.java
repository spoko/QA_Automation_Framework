package com.selenium.course.tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.selenium.course.tests.base.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginTests extends TestUtil {
    private WebDriver driver = setUp();

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
    @DataProvider(name = "usersCsv")
    public static Object[][] readUsersFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/userList.csv"))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }

        @Test (dataProvider = "usersCsv") //This cames from TestNG
        public void unsuccessfulLogin(String userName, String password){
            driver.get("https://www.saucedemo.com/");

            WebElement userNameInput = driver.findElement(By.id("user-name"));
            userNameInput.sendKeys(userName);

            WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
            passwordInput.sendKeys(password);

            WebElement loginBtn = driver.findElement(By.name("login-button"));
            loginBtn.click();

            WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

            Assert.assertTrue(wrongUserBtn.isDisplayed());
        }
    }
