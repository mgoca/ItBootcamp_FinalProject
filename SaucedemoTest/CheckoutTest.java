package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();
        proceedToCheckoutInfo();
    }

    @Test
    public void inputValidCredentialsInCheckoutForm() throws InterruptedException {

        String validFirstName = "Jon";
        checkoutInformation.inputFirstName(validFirstName);

        String validLastName = "Doe";
        checkoutInformation.inputLastName(validLastName);

        String validPostalCode = "21000";
        checkoutInformation.inputPostalCode(validPostalCode);

        checkoutInformation.continueCheckout();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
