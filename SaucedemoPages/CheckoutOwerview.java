package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CheckoutOwerview {
    WebDriver driver;
    WebDriverWait wdwait;

    public CheckoutOwerview(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    WebElement finish;
    @FindBy(id = "cancel")
    WebElement cancel;
    @FindBy(className = "inventory_item_name")
    List<WebElement> listProductNames;
    @FindBy(className = "inventory_item_price")
    List<WebElement> listProductPrices;
    @FindBy(className = "summary_subtotal_label")
    WebElement subtotal;
    @FindBy(className = "summary_tax_label")
    WebElement tax;

    //----------GO TO

    public void finishCheckout() {
        finish.click();
    }

    public void cancelCheckout() {
        cancel.click();
    }

    //---------GET ELEMENTS

    public List<WebElement> getListProductNames() {
        return listProductNames;
    }

    public List<WebElement> getListProductPrices() {
        return listProductPrices;
    }

    public WebElement getSubtotal() {
        return subtotal;
    }

    public WebElement getTax() {
        return tax;
    }

    //---------SUM METHOD

    public List<Double> listProductPricesFromCheckout() {
        List<WebElement> pricesList = getListProductPrices();

        List<Double> priceProductsList = new ArrayList<>();
        for (int i = 0; i < pricesList.size(); i++) {
            priceProductsList.add(Double.parseDouble(pricesList.get(i).getText().replace("$", "")));
        }
        return priceProductsList;
    }

    public double sumProductsInCart(List<Double> priceProductsList) {
        double sum = 0;
        for (int i = 0; i < priceProductsList.size(); i++) {
            sum = sum + priceProductsList.get(i);
        }
        return sum;
    }


    //-----------METHOD FOR TAKING A NUMBER FROM ELEMENT

    public double subtotalCheckout() {
        String s = this.getSubtotal().getText().replace("Item total: $", "");
        double subtotal = Double.parseDouble(s);
        return subtotal;
    }

    public double taxCheckout() {
        String s = this.getTax().getText().replace("Tax: $", "");
        double tax = Double.parseDouble(s);
        return tax;
    }
}