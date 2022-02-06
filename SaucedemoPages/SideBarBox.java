package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideBarBox {
    WebDriver driver;
    WebDriverWait wdwait;

    public SideBarBox(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement barButton;
    @FindBy(id = "inventory_sidebar_link")
    WebElement allItems;
    @FindBy(id = "about_sidebar_link")
    WebElement about;
    @FindBy(id = "logout_sidebar_link")
    WebElement logOut;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppState;

    //----------GET ELEMENTS

    public WebElement getAbout() {
        return about;
    }

    //--------METHOD SIDEBAR

    public void openSideBar() {
        barButton.click();
    }

    public void goToAllItems() {
        allItems.click();
    }

    public void goToAbout() {
        about.click();
    }

    public void logOutFromPage() {
        logOut.click();
    }

    public void resetCart() {
        resetAppState.click();
    }
}
