package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductFromCartTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();
    }

    @Test
    public void removeProductFromCart() {
        productSaucedemo.addBackpack();
        String expectedCartNumber = "1";
        String actualCartNumber = productSaucedemo.chartNumberMessage();
        Assert.assertEquals(actualCartNumber, expectedCartNumber);

        productSaucedemo.removeBackpack();

        boolean cartInfo = false;
        try {
            WebElement cartText = driver.findElement(By.className("shopping_cart_badge"));
            cartInfo = cartText.isDisplayed();
        } catch (NoSuchElementException e) {

        }
        Assert.assertFalse(cartInfo);
    }

}




