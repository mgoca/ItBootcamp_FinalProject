package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProblemUserTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInProblemUserOnSite();
    }

    @Test(priority = 1)
    public void wrongProductPicturesTestProblemUser() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);

        String srcImageActual = productSaucedemo.getImageBackpack().getAttribute("src");
        System.out.println(srcImageActual);
        String srcImageExpected = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg";
        Assert.assertNotEquals(srcImageActual, srcImageExpected);
    }

    @Test(priority = 2)
    public void checkoutImpossibleProblemUser() {
        productSaucedemo.addBackpack();
        productSaucedemo.goToCart();
        cart.goToCheckout();
        inputAddressData();

        String urlExpected = "https://www.saucedemo.com/checkout-step-two.html";
        String urlActual = "https://www.saucedemo.com/checkout-step-one.html";

        Assert.assertNotEquals(urlActual, urlExpected);
    }
}