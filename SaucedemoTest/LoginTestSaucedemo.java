package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestSaucedemo extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    //    lOG IN TESTS

    //----------VALID DATA--->STANDARD_USER

    @Test
    public void logInOnSiteWithValidData() {
        String validUsername = "standard_user";
        loginSaucedemo.insertUsername(validUsername);

        String validPassword = "secret_sauce";
        loginSaucedemo.insertPassword(validPassword);

        loginSaucedemo.clikOnLogin();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //--------INVALID USERNAME

    @Test
    public void logInOnSiteWhithInvalidUsername() {
        String invalidUsername = "wrong_username";
        loginSaucedemo.insertUsername(invalidUsername);

        String validPassword = "secret_sauce";
        loginSaucedemo.insertPassword(validPassword);

        loginSaucedemo.clikOnLogin();

        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = loginSaucedemo.textErrorMessageBox();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    //----------INVALIDPASSWORD

    @Test
    public void logInOnSiteWithInvalidPassword() {
        String validUsername = "standard_user";
        loginSaucedemo.insertUsername(validUsername);

        String invalidPassword = "wrong_password";
        loginSaucedemo.insertPassword(invalidPassword);

        loginSaucedemo.clikOnLogin();

        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = loginSaucedemo.textErrorMessageBox();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    //----------WITHOUT USERNAME(INPUT IS BLANK)

    @Test
    public void logInOnSiteWithoutUsername() {
        loginSaucedemo.blankUsernane();
        String validPassword = "secret_sauce";
        loginSaucedemo.insertPassword(validPassword);

        loginSaucedemo.clikOnLogin();

        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = loginSaucedemo.textErrorMessageBox();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertTrue(loginSaucedemo.getErrorBoxMessage().isDisplayed());
    }

    //----------WITHOUT PASSWORD(PASSWORD IS BLANK)

    @Test
    public void logInOnSiteWithoutPassword() {
        String validUsername = "standard_user";
        loginSaucedemo.insertUsername(validUsername);

        loginSaucedemo.blankPassword();

        loginSaucedemo.clikOnLogin();

        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualErrorMessage = loginSaucedemo.textErrorMessageBox();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertTrue(loginSaucedemo.getErrorBoxMessage().isDisplayed());
    }

    //------------WITHOUT USERNAME AND PASSWORD(USERNAME AND PASSWORD ARE BLANK)

    @Test
    public void logInOnSiteWithoutUsernameAndPassword() {
        loginSaucedemo.blankUsernane();
        loginSaucedemo.blankPassword();
        loginSaucedemo.clikOnLogin();

        String expectedErrorMessage = "Epic sadface: Username is required";
        String actualErrorMessage = loginSaucedemo.textErrorMessageBox();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertTrue(loginSaucedemo.getErrorBoxMessage().isDisplayed());
    }

    //-------------LOCKED_OUT_USER

    @Test
    public void logInOnSiteWithLockedOutUser() {
        String lockedUsername = "locked_out_user";
        loginSaucedemo.insertUsername(lockedUsername);

        String validPassword = "secret_sauce";
        loginSaucedemo.insertPassword(validPassword);

        loginSaucedemo.clikOnLogin();

        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = loginSaucedemo.textErrorMessageBox();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertTrue(loginSaucedemo.getErrorBoxMessage().isDisplayed());
    }

    //-----------PROBLEM_USER

    @Test
    public void logInOnSiteWithProblemUser() {
        String problemUsername = "problem_user";
        loginSaucedemo.insertUsername(problemUsername);

        String validPassword = "secret_sauce";
        loginSaucedemo.insertPassword(validPassword);

        loginSaucedemo.clikOnLogin();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    //----------PERFORMANCE_GLITCH_USER

    @Test
    public void logInOnSiteWithPerformanceGlitchUser() {
        String performanceUsername = "performance_glitch_user";
        loginSaucedemo.insertUsername(performanceUsername);

        String validPassword = "secret_sauce";
        loginSaucedemo.insertPassword(validPassword);

        loginSaucedemo.clikOnLogin();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}