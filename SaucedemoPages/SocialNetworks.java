package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SocialNetworks {

    WebDriver driver;
    WebDriverWait wdwait;

    public SocialNetworks(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "social_twitter")
    WebElement twitter;
    @FindBy(className = "social_facebook")
    WebElement facebook;
    @FindBy(className = "social_linkedin")
    WebElement linkedin;


    //--------METHOD GO TO SOCIAL NETWORK

    public void goToTwitter() {
        twitter.click();
    }

    public void goToFacebook() {
        facebook.click();
    }

    public void goToLinkedin() {
        linkedin.click();
    }
}