package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinisCheckoutTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();
        proceedToCheckoutInfo();
    }

    @Test
    public void finisCheckout() {
        String validFirstName = "Jon";
        checkoutInformation.inputFirstName(validFirstName);

        String validLastName = "Doe";
        checkoutInformation.inputLastName(validLastName);

        String validPostalCode = "21000";
        checkoutInformation.inputPostalCode(validPostalCode);

        checkoutInformation.continueCheckout();

        checkoutOwerview.finishCheckout();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(actualUrl, expectedUrl);

        String actualMessage = checkoutComplete.messageComplete();
        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualMessage, expectedMessage);

        wdwait.until(ExpectedConditions.visibilityOf(checkoutComplete.getPicture()));
        Assert.assertTrue(checkoutComplete.getPicture().isDisplayed());
    }
}
