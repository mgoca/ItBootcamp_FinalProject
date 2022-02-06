package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutComplete {

    WebDriver driver;
    WebDriverWait wdwait;

    public CheckoutComplete(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    WebElement titlePage;
    @FindBy(className = "complete-header")
    WebElement textCompleteElement;
    @FindBy(className = "pony_express")
    WebElement picture;
    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public String textTitlePage() {
        return titlePage.getText();
    }

    public String messageComplete() {
        return textCompleteElement.getText();
    }

    public WebElement getPicture() {
        return picture;
    }
}


