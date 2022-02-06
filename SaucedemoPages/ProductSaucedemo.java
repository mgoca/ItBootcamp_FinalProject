package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductSaucedemo {

    WebDriver driver;
    WebDriverWait wdwait;

    public ProductSaucedemo(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    //---------TITLE PAGE
    @FindBy(className = "title")
    WebElement titlePage;

    //----------CART ELEMENT
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cartButton;
    @FindBy(className = "shopping_cart_badge")
    WebElement numberOfProductsInChart;

    //---------LIST ELEMENTS
    @FindBy(className = "inventory_item_name")
    List<WebElement> listProductsName;
    @FindBy(className = "inventory_item_price")
    List<WebElement> listProductsPrice;

    //-----------ADD BUTTON PRODUCT
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addSauceLabsBackpack;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addSauceLabsBikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addSauceLabsBoltTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addSauceLabsFleeceJacket;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement addSauceLabsOnesie;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement addTestallTheThingTShirtRed;

    //----------REMOVE BUTTON PRODUCT

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeSauceLabsBackpack;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeSauceLabsBikeLight;
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeSauceLabsBoltTShirt;
    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeSauceLabsFleeceJacket;
    @FindBy(id = "remove-sauce-labs-onesie")
    WebElement removeSauceLabsLabsOnesie;
    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    WebElement removeTestallTheThingTShirtRed;

    //-------lINK TO PRODUCT

    @FindBy(id = "item_4_img_link")
    WebElement sauceLabsBackpack;
    @FindBy(id = "item_0_img_link")
    WebElement sauceLabsBikeLight;
    @FindBy(id = "item_1_img_link")
    WebElement sauceLabsBoltTShirt;
    @FindBy(id = "item_5_img_link")
    WebElement sauceLabsFleeceJacket;
    @FindBy(id = "item_2_img_link")
    WebElement sauceLabsOnesie;
    @FindBy(id = "item_3_img_link")
    WebElement testAllTheThingsTShirtRed;

    //--------PICTURE ELEMENT

    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
    WebElement imageBackpack;


    //---------METHOD ADD PRODUCT IN CART

    public void addBackpack() {
        addSauceLabsBackpack.click();
    }

    public void addBikeLight() {
        addSauceLabsBikeLight.click();
    }

    public void addBoltShirt() {
        addSauceLabsBoltTShirt.click();
    }

    public void addFleeceJacket() {
        addSauceLabsFleeceJacket.click();
    }

    public void addOnesie() {
        addSauceLabsOnesie.click();
    }

    public void addTShirtRed() {
        addTestallTheThingTShirtRed.click();
    }


    //__________METHOD REMOVE ELEMENT FROM CART

    public void removeBackpack() {
        removeSauceLabsBackpack.click();
    }

    public void removeBikeLight() {
        removeSauceLabsBikeLight.click();
    }

    public void removeBoltTShirt() {
        removeSauceLabsBoltTShirt.click();
    }

    public void removeFleeceJacket() {
        removeSauceLabsFleeceJacket.click();
    }

    public void removeOnesie() {
        removeSauceLabsLabsOnesie.click();
    }

    public void removeTShirtRed() {
        removeTestallTheThingTShirtRed.click();
    }


    //-----------GO TO PRODUCT INFO

    public void goToBackpack() {
        sauceLabsBackpack.click();
    }

    public void goToBikeLight() {
        sauceLabsBikeLight.click();
    }

    public void goToBoltShirt() {
        sauceLabsBoltTShirt.click();
    }

    public void goToFleeceJacket() {
        sauceLabsFleeceJacket.click();
    }

    public void goToOnesie() {
        sauceLabsOnesie.click();
    }

    public void goToTShirtRed() {
        testAllTheThingsTShirtRed.click();
    }


    //-----------GO TO CART

    public void goToCart() {
        cartButton.click();
    }


    //----------GET PRODUCT ELEMENT

    public WebElement getAddSauceLabsBackpack() {

        return addSauceLabsBackpack;
    }

    public WebElement getRemoveSauceLabsBackpack() {

        return removeSauceLabsBackpack;
    }

    public WebElement getCartButton() {

        return cartButton;
    }

    public WebElement getNumberOfProductsInChart() {

        return numberOfProductsInChart;
    }

    public WebElement getTitlePage() {
        return titlePage;
    }

    public List<WebElement> getListProductsName() {

        return listProductsName;
    }

    public List<WebElement> getListProductsPrice() {
        return listProductsPrice;
    }

    public WebElement getImageBackpack() {
        return imageBackpack;
    }

    //----------SORT METHODS

    public List<String> sortListProductNamesAZ() {
        List<String> nameProductList = new ArrayList<>();
        List<WebElement> listOfProductNames = this.getListProductsName();

        for (int i = 0; i < listOfProductNames.size(); i++) {
            nameProductList.add(listOfProductNames.get(i).getText());
        }
        Collections.sort(nameProductList);
        return nameProductList;
    }

    public List<String> sortListProductNamesZA() {
        List<String> nameProductList = new ArrayList<>();
        List<WebElement> listOfProductNames = this.getListProductsName();

        for (int i = 0; i < listOfProductNames.size(); i++) {
            nameProductList.add(listOfProductNames.get(i).getText());
        }
        nameProductList.sort(Comparator.reverseOrder());
        return nameProductList;
    }

    public List<Double> sortListProductPricesLowHigh() {
        List<WebElement> pricesList = this.getListProductsPrice();

        List<Double> priceProductList = new ArrayList<>();
        for (int i = 0; i < pricesList.size(); i++) {
            priceProductList.add(Double.parseDouble(pricesList.get(i).getText().replace("$", "")));
        }
        priceProductList.sort(Comparator.naturalOrder());
        return priceProductList;
    }

    public List<Double> sortListProductPricesHighLow() {
        List<WebElement> pricesList = this.getListProductsPrice();

        List<Double> priceProductList = new ArrayList<>();
        for (int i = 0; i < pricesList.size(); i++) {
            priceProductList.add(Double.parseDouble(pricesList.get(i).getText().replace("$", "")));
        }
        priceProductList.sort(Comparator.reverseOrder());
        return priceProductList;
    }


    //----------GET TEXT MESSAGE FROM ELEMENTS

    public String messageFromButtonAdd() {

        return getAddSauceLabsBackpack().getText();
    }

    public String messageFromButtonRemove() {

        return getRemoveSauceLabsBackpack().getText();
    }

    public String chartNumberMessage() {

        return getCartButton().getText();
    }

    public String textTitlePage() {

        return getTitlePage().getText();
    }

    public List<String> getProductNames() {
        List<String> newList = new ArrayList<String>();
        for (int i = 0; i < this.getListProductsName().size(); i++) {
            newList.add(this.getListProductsName().get(i).getText());
        }
        return newList;
    }

    public List<Double> getProductPrices() {
        List<WebElement> pricesList = this.getListProductsPrice();
        List<Double> priceProductList = new ArrayList<>();
        for (int i = 0; i < pricesList.size(); i++) {
            priceProductList.add(Double.parseDouble(pricesList.get(i).getText().replace("$", "")));
        }
        return priceProductList;
    }
}


