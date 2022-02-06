package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();

    }

    @Test(priority = 1)
    public void removeProducts() {

        productSaucedemo.addOnesie();
        productSaucedemo.addBoltShirt();
        productSaucedemo.goToCart();

        String actualNumberOfProductInCart = cart.chartNumberMessageText();
        String expectedNumberOfProductInCart = "2";
        Assert.assertEquals(actualNumberOfProductInCart, expectedNumberOfProductInCart);

        cart.removeBoltTShirt();
        String actualCartNumber = cart.chartNumberMessageText();
        String expectedCartNumber = "1";
        Assert.assertEquals(actualCartNumber, expectedCartNumber);
    }

    @Test(priority = 2)
    public void continueShopping() {

        productSaucedemo.addTShirtRed();
        productSaucedemo.goToCart();

        String actualTitlePage = cart.textPageTitle();
        String expectedTitlePage = "YOUR CART";
        Assert.assertEquals(actualTitlePage, expectedTitlePage);

        cart.proceedToShopping();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 3)
    public void proceedToCheckout() {

        productSaucedemo.addBikeLight();
        productSaucedemo.goToCart();
        cart.goToCheckout();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
