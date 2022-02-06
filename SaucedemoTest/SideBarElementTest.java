package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SideBarElementTest extends BaseSauceDemo {


    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();
    }

    @Test
    public void goToProductPage() {
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        sideBarBox.openSideBar();
        waiter(sideBarBox.getAbout());
        sideBarBox.goToAllItems();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);

        String actualTitle = productSaucedemo.textTitlePage();
        String expectedTitle = "PRODUCTS";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void goToAboutPage() {
        sideBarBox.openSideBar();
        waiter(sideBarBox.getAbout());
        sideBarBox.goToAbout();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://saucelabs.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void logOutFromPage() {
        sideBarBox.openSideBar();
        waiter(sideBarBox.getAbout());
        sideBarBox.logOutFromPage();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void resetAppStateFromProductsPage() {
        productSaucedemo.addBackpack();
        sideBarBox.openSideBar();
        waiter(sideBarBox.getAbout());
        sideBarBox.resetCart();
        boolean cartInfo = false;
        try {
            WebElement cartText = driver.findElement(By.className("shopping_cart_badge"));
            cartInfo = cartText.isDisplayed();
        } catch (NoSuchElementException e) {

        }
        Assert.assertFalse(cartInfo);

        String actualMessageOnButton = productSaucedemo.messageFromButtonRemove();
        String expectedMessageOnButton = "ADD";
        Assert.assertNotEquals(actualMessageOnButton, expectedMessageOnButton);
    }
}
