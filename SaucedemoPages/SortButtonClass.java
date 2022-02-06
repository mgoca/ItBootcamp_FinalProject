package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortButtonClass {
    WebDriver driver;
    WebDriverWait wdwait;

    public SortButtonClass(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product_sort_container")
    WebElement sort;


    //-------SELECT SORT

    public void selectSortNameAZ() {
        Select sortAZ = new Select(this.sort);
        sortAZ.selectByValue("az");
    }

    public void selectSortNameZA() {
        Select sortZA = new Select(this.sort);
        sortZA.selectByValue("za");
    }

    public void selectSortPriceLowHigh() {
        Select sortLowHigh = new Select(this.sort);
        sortLowHigh.selectByValue("lohi");
    }

    public void selectSortPriceHighLow() {
        Select sortHighLow = new Select(this.sort);
        sortHighLow.selectByValue("hilo");
    }
}