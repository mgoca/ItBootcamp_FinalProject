package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSaucedemo {
    WebDriver driver;
    WebDriverWait wdwait;

    public LoginSaucedemo(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement login;
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
    WebElement errorBoxMessage;

    public WebElement getErrorBoxMessage() {
        return errorBoxMessage;
    }
    //-----------INPUT DATA

    public void insertUsername(String name) {
        username.clear();
        username.sendKeys(name);
    }

    public void insertPassword(String pass) {
        username.clear();
        password.sendKeys(pass);
    }

    public void clikOnLogin() {
        login.click();
    }

    public String textErrorMessageBox() {
        return errorBoxMessage.getText();
    }

    public void blankUsernane() {
        username.clear();
    }

    public void blankPassword() {
        password.clear();
    }

}



