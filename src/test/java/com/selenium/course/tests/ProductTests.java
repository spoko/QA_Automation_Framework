package com.selenium.course.tests;
import Pages.*;
import com.selenium.course.tests.base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTests extends TestUtil {

    @Test
    public void addItemToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productPage = loginPage.login("standard_user","secret_sauce");
        productPage.addToCartByProductName("backpack");

        //Soft assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.getNumbersInTheCart(), 1,
                "Because we have added one item in the cart.");
        softAssert.assertEquals(productPage.getNumbersInTheCart(), 1,
                "Because we have added one item in the cart.");
        softAssert.assertEquals(productPage.getNumbersInTheCart(), 1,
                "Because we have added one item in the cart.");

        //Hard assert
        Assert.assertEquals(productPage.getNumbersInTheCart(), 1,
                "Because we have added one item in the cart.");

        softAssert.assertAll();

    }
}
