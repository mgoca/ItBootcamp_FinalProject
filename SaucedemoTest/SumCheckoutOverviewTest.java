package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SumCheckoutOverviewTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();
        proceedToCheckoutInfo();
        inputAddressData();
    }

    @Test
    public void sumProductsInCart() {

        double expectedItemTotal = checkoutOwerview.sumProductsInCart(checkoutOwerview.listProductPricesFromCheckout());
        double actualItemTotal = checkoutOwerview.subtotalCheckout();

        System.out.println(actualItemTotal);
        System.out.println(expectedItemTotal);

        Assert.assertEquals(actualItemTotal, expectedItemTotal);
    }
}
