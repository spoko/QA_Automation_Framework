package com.selenium.course.tests;
import Pages.*;
import com.selenium.course.tests.base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends TestUtil {

    @Test
    public void addItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productPage = loginPage.login("standard_user","secret_sauce");
        productPage.addToCartByProductName("backpack");

        Assert.assertEquals(productPage.getNumbersInTheCart(), 1, "Because we have added one item in the cart.");
    }
}
