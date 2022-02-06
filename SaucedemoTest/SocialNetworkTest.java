package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SocialNetworkTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {

        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();
    }


    @Test
    public void goToTwitterSauceLabs() {
        String winHandleBefore = driver.getWindowHandle();
        socialNetworks.goToTwitter();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String expectedUrl = "https://twitter.com/saucelabs";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void goToFacebookSauceLabs() {
        String winHandleBefore = driver.getWindowHandle();
        socialNetworks.goToFacebook();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String expectedUrl = "https://www.facebook.com/saucelabs";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void goToLinkedinSauceLabs() {
        String winHandleBefore = driver.getWindowHandle();
        socialNetworks.goToLinkedin();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String expectedUrl = "https://www.linkedin.com/company/sauce-labs/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
