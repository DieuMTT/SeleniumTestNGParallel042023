package com.dieutester.pages;

import com.dieutester.helpers.PropertiesHelper;
import com.dieutester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.dieutester.constants.ConfigData.*;
import static com.dieutester.keywords.WebUI.*;

public class AddNewProductPage {
    private By headerAddNewProductPage = By.xpath("//h5[normalize-space()='Add New Product']");
    private By headerProductInformationPage = By.xpath("//h5[normalize-space()='Product Information']");
    private By inputProductName = By.xpath("//label[.='Product Name *']/following-sibling::div//input");
    private By dropdownCategory = By.xpath("//div[@id='category']//button[@data-id='category_id']");

    private By inputSearchCategory = By.xpath("//div[@id='category']//input[@type='search']");
    private By inputUnit = By.xpath("//label[normalize-space()='Unit']/following-sibling::div//input");
    private By inputMinimumPurchaseQty = By.xpath("//label[.='Minimum Purchase Qty *']/following-sibling::div/input");
    private By inputTags = By.xpath("//label[contains(text(),'Tags')]/following-sibling::div//tags");
    //tags[@role='tagslist']

    //Product price + stock
    private By headerProductPriceStock = By.xpath("//h5[normalize-space()='Product price + stock']");
    private By inputUnitPrice = By.xpath("//label[.='Unit price *']/following-sibling::div/input");
    private By inputDiscountDateRange = By.xpath("//label[normalize-space()='Discount Date Range']/following-sibling::div/input");
    private By inputDiscount = By.xpath("//label[normalize-space()='Discount *']/following-sibling::div/input");
    private By listDiscountType = By.xpath("//select[@name='discount_type']");
    private By dropdownDiscount = By.xpath("//label[normalize-space()='Discount *']/following-sibling::div//div/button");
    private By inputQuantity = By.xpath("//input[@name='current_stock']");
    private By inputSKU = By.xpath("//label[normalize-space()='SKU']/following-sibling::div/input");
    private By inputExternalLink = By.xpath("//label[normalize-space()='External link']/following-sibling::div/input");
    private By inputExternalLinkButtonText = By.xpath("//label[normalize-space()='External link button text']/following-sibling::div/input");

    private By buttonSaveAndPublish = By.xpath("//form[@id='choice_form']//button[normalize-space()= 'Save & Publish']");

    public void selectCategoryName(String categoryName) {
        clickElement(dropdownCategory);
        setTextAndKey(inputSearchCategory, categoryName, Keys.ENTER);
    }

    public void verifyHeaderAddNewProductPage() {
        waitForPageLoaded();
        Assert.assertTrue(getWebElement(headerAddNewProductPage).isDisplayed(),
                "Fail.Header Add New Product Page not display");
        Assert.assertEquals(getElementText(headerAddNewProductPage), "Add New Product",
                "Fail.Header Add New Product Page not match");
    }

    public InHouseProductsPage inputFormData(String productName) {
        waitForPageLoaded();
        //Input Product Information
        setText(inputProductName, productName);
        selectCategoryName(CATEGORY_NAME);
        clearText(inputUnit);
        setText(inputUnit, PropertiesHelper.getValue("unit"));
        clearText(inputMinimumPurchaseQty);
        setText(inputMinimumPurchaseQty, PropertiesHelper.getValue("minimum_purchase_qty"));
        moveToElement(inputTags);
        setText(inputTags, PropertiesHelper.getValue("tags"));
        //Input Product price + stock
        clearText(inputUnitPrice);
        setText(inputUnitPrice, PropertiesHelper.getValue("unit_price"));
        clearText(inputDiscount);
        setText(inputDiscount, PropertiesHelper.getValue("discount"));
        clearText(inputQuantity);
        setText(inputQuantity, PropertiesHelper.getValue("quantity"));
        clickElement(buttonSaveAndPublish);
        waitForPageLoaded();
        return new InHouseProductsPage();
    }

}
