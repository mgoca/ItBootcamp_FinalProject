package SaucedemoTest;

import SaucedemoBase.BaseSauceDemo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SortFunctionTest extends BaseSauceDemo {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInOnSite();
    }

    @Test(priority = 1)
    public void sortTestNameZA() {
        sortButtonClass.selectSortNameZA();

        List<String> actualSortResult = productSaucedemo.getProductNames();
        System.out.println(actualSortResult);

        List<String> expectedSortResult = productSaucedemo.sortListProductNamesZA();
        System.out.println(expectedSortResult);

        Assert.assertEquals(actualSortResult, expectedSortResult);
    }

    @Test(priority = 2)
    public void sortTestNameAZ() {
        sortButtonClass.selectSortNameAZ();

        List<String> actualSortResult = productSaucedemo.getProductNames();
        System.out.println(actualSortResult);
        List<String> expectedSortResult = productSaucedemo.sortListProductNamesAZ();
        System.out.println(expectedSortResult);

        Assert.assertEquals(actualSortResult, expectedSortResult);
    }

    @Test(priority = 3)
    public void sortTestPriceLowHigh() {
        sortButtonClass.selectSortPriceLowHigh();

        List<Double> actualSortResult = productSaucedemo.getProductPrices();
        System.out.println(actualSortResult);
        List<Double> expectedSortResult = productSaucedemo.sortListProductPricesLowHigh();
        System.out.println(expectedSortResult);

        Assert.assertEquals(actualSortResult, expectedSortResult);
    }

    @Test(priority = 4)
    public void sortTestPriceHighLow() {
        sortButtonClass.selectSortPriceHighLow();

        List<Double> actualSortResult = productSaucedemo.getProductPrices();
        System.out.println(actualSortResult);

        List<Double> expectedSortResult = productSaucedemo.sortListProductPricesHighLow();
        System.out.println(expectedSortResult);

        Assert.assertEquals(actualSortResult, expectedSortResult);
    }
}
