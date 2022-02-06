package SaucedemoBase;

import SaucedemoPages.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BaseSauceDemo {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginSaucedemo loginSaucedemo;
    public ProductSaucedemo productSaucedemo;
    public SideBarBox sideBarBox;
    public Cart cart;
    public SortButtonClass sortButtonClass;
    public CheckoutOwerview checkoutOwerview;
    public CheckoutInformation checkoutInformation;
    public CheckoutComplete checkoutComplete;
    public SocialNetworks socialNetworks;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginSaucedemo = new LoginSaucedemo(driver, wdwait);
        productSaucedemo = new ProductSaucedemo(driver, wdwait);
        sideBarBox = new SideBarBox(driver, wdwait);
        cart = new Cart(driver, wdwait);
        sortButtonClass = new SortButtonClass(driver, wdwait);
        checkoutOwerview = new CheckoutOwerview(driver, wdwait);
        checkoutInformation = new CheckoutInformation(driver, wdwait);
        checkoutComplete = new CheckoutComplete(driver, wdwait);
        socialNetworks=new SocialNetworks(driver, wdwait);
    }

    public void waiter(WebElement element) {

        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void logInOnSite() {
        String validUsername = "standard_user";
        loginSaucedemo.insertUsername(validUsername);

        String validPassword = "secret_sauce";
        loginSaucedemo.insertPassword(validPassword);

        loginSaucedemo.clikOnLogin();
    }

    public void logInProblemUserOnSite() {
        String problemUsername = "problem_user";
        loginSaucedemo.insertUsername(problemUsername);

        String validPassword = "secret_sauce";
        loginSaucedemo.insertPassword(validPassword);

        loginSaucedemo.clikOnLogin();
    }

    public void proceedToCheckoutInfo() {
        productSaucedemo.addOnesie();
        productSaucedemo.addFleeceJacket();
        productSaucedemo.goToCart();
        cart.goToCheckout();
    }

    public void clearFromCart() {
        productSaucedemo.removeOnesie();
        productSaucedemo.removeFleeceJacket();
    }

    public void inputAddressData() {
        String validFirstName = "Jon";
        checkoutInformation.inputFirstName(validFirstName);

        String validLastName = "Doe";
        checkoutInformation.inputLastName(validLastName);

        String validPostalCode = "21000";
        checkoutInformation.inputPostalCode(validPostalCode);

        checkoutInformation.continueCheckout();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @AfterSuite
    public void end() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }
}
