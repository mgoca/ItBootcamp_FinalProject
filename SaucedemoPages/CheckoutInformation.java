package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutInformation {
    WebDriver driver;
    WebDriverWait wdwait;

    public CheckoutInformation(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement postalCodeField;
    @FindBy(id = "cancel")
    WebElement cancelOrderButton;
    @FindBy(id = "continue")
    WebElement continueButton;


    //--------GET ELEMENTS

    public WebElement getCancelOrderButton() {
        return cancelOrderButton;
    }


    //---------INPUT FIELDS

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    //---------CONTINUE AND CANCEL CHECKOUT METHODS

    public void continueCheckout() {
        continueButton.click();
    }

    public void cancelCheckout() {
        cancelOrderButton.click();
    }

}
