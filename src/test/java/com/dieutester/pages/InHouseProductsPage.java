package com.dieutester.pages;

import com.dieutester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.dieutester.keywords.WebUI.*;

public class InHouseProductsPage {
    private By headerAllProductPage = By.xpath("//h1[normalize-space()='All products']");
    private By buttonEditProduct = By.xpath("(//i[contains(@class,'las la-edit')])[1]");
    private By inputSearchProduct = By.xpath("//form[@id='sort_products']//input[@id='search']");
    private By firstItemProductOnTable = By.xpath("(//span[@class='text-muted text-truncate-2'])[1]");

    public void searchAndVerifyProduct(String productName) {
        waitForPageLoaded();
        setText(inputSearchProduct, productName);
        sleep(2);
        Assert.assertTrue(WebUI.checkElementExist(firstItemProductOnTable), "Không tìm thấy Product.");
    }

    public EditProductPage clickButtonEditProduct() {
        waitForPageLoaded();
        clickElement(buttonEditProduct);
        waitForPageLoaded();
        return new EditProductPage();
    }
}
