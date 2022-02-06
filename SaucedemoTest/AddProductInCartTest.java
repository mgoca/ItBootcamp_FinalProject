package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddProductInCartTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();

    }

    @Test(priority = 1)
    public void addOneProductInCart() {

        productSaucedemo.addBackpack();

        String actualMessageRemove = productSaucedemo.messageFromButtonRemove();
        String expectedMessageRemove = "REMOVE";
        Assert.assertEquals(actualMessageRemove, expectedMessageRemove);

        String expectedChartNumber = "1";
        String actualChartNumber = productSaucedemo.chartNumberMessage();
        Assert.assertEquals(actualChartNumber, expectedChartNumber);

        productSaucedemo.removeBackpack();
    }

    @Test(priority = 2)
    public void addAllProductsInChart() {

        productSaucedemo.addBackpack();
        productSaucedemo.addBikeLight();
        productSaucedemo.addBoltShirt();
        productSaucedemo.addFleeceJacket();
        productSaucedemo.addOnesie();
        productSaucedemo.addTShirtRed();

        String expectedChartNumber = "6";
        String actualChartNumber = productSaucedemo.chartNumberMessage();
        Assert.assertEquals(actualChartNumber, expectedChartNumber);
    }

    @AfterMethod
    public void pauseBetweenTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
}
