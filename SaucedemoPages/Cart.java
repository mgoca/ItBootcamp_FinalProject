package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Cart {
    WebDriver driver;
    WebDriverWait wdwait;

    public Cart(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    WebElement pageTitle;
    @FindBy(id = "continue-shopping")
    WebElement continueShopping;
    @FindBy(id = "checkout")
    WebElement checkout;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeSauceLabsBackpack;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeSauceLabsBikeLIght;
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeSauceLabsBoltTShirt;
    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeSauceLabsFleeceJacket;
    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement removeSauceLabsOnesie;
    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    WebElement removeSauceLabsTShirtRed;

    //---------LIST ELEMENTS

    @FindBy(className = "cart_item")
    List<WebElement> listCartItems;

    //----------CART ELEMENT

    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;
    @FindBy(className = "shopping_cart_badge")
    WebElement numberOfProductsInChart;


    //----------REMOVE METHOD

    public void removeBackpack() {

        removeSauceLabsBackpack.click();
    }

    public void removeBikeLIght() {
        removeSauceLabsBikeLIght.click();
    }

    public void removeBoltTShirt() {
        removeSauceLabsBoltTShirt.click();
    }

    public void removeFleeceJacket() {
        removeSauceLabsFleeceJacket.click();
    }

    public void removeOnesie() {
        removeSauceLabsOnesie.click();
    }

    public void removeTShirtRed() {
        removeSauceLabsTShirtRed.click();
    }

    //---------CONTINUE SHOPPING METHOD

    public void proceedToShopping() {
        continueShopping.click();
    }

    //----------GO TO CHECKOUT METHOD

    public void goToCheckout() {
        checkout.click();
    }

    //----------GET ELEMENTS

    public WebElement getNumberOfProductsInChart() {
        return numberOfProductsInChart;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    //---------GET TEXT MESSAGE FROM ELEMENTS

    public String chartNumberMessageText() {
        return numberOfProductsInChart.getText();
    }

    public String textPageTitle() {
        return getPageTitle().getText();
    }

}
