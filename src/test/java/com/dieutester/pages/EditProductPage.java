package com.dieutester.pages;

import com.dieutester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.dieutester.constants.ConfigData.*;
import static com.dieutester.keywords.WebUI.*;

public class EditProductPage {
    private By headerEditProductPage = By.xpath("//h1[normalize-space()='Edit Product']");

    private By inputProductName = By.xpath("//label[normalize-space()='Product Name']/following-sibling::div/input");
    private By buttonUpdateProduct = By.xpath("//form[@id='choice_form']//button[normalize-space()='Update Product']");
    private By dropdownCategory = By.xpath("//label[normalize-space()='Category']/following-sibling::div//button[@data-id='category_id']");
    private By inputUnit = By.xpath("//label[normalize-space()='Unit']/following-sibling::div//input");
    private By inputMinimumPurchaseQty = By.xpath("//input[@name='min_qty']");
    private By inputTags = By.xpath("//tags[@role='tagslist']");
    private By inputUnitPrice = By.xpath("//label[.='Unit price']/following-sibling::div/input");
    private By inputDiscount = By.xpath("//label[normalize-space()='Discount']/following-sibling::div/input");
    private By inputQuantity = By.xpath("//input[@name='current_stock']");

    public void testEditProduct() {
        waitForPageLoaded();
        setText(inputProductName, " " + "Edited");
        clickElement(buttonUpdateProduct);
        waitForPageLoaded();
    }

    public void verifyEditProductPage() {
        Assert.assertTrue(getWebElement(headerEditProductPage).isDisplayed(), "Fail.headerEditProductPage does not display");
        Assert.assertEquals(getWebElement(headerEditProductPage).getText(), "Edit Product", "Fail.headerEditProductPage does not match");
    }

    public void verifyDataProduct(String productName) {
        waitForPageLoaded();
        Assert.assertEquals(getElementAttribute(inputProductName, "value"), productName + " Edited");
        waitForPageLoaded();
    }

    public void verifyProductsDetail(String productName) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(WebUI.getElementAttribute(inputProductName, "value"), productName, "Giá trị Tên Product không đúng");
        softAssert.assertEquals(WebUI.getElementText(dropdownCategory), CATEGORY_NAME, "Giá trị Category không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputMinimumPurchaseQty, "value"), "3", "Giá trị MinimumPurchaseQty không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputUnit, "value"), "KG", "Giá trị Unit không đúng");
//        softAssert.assertEquals(WebUI.getElementAttribute(inputTags, "value"), "", "Giá trị Tags không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputUnitPrice, "value"), "100000.00", "Giá trị UnitPrice không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputQuantity, "value"), "1", "Giá trị Quantity không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputDiscount, "value"), "10000.00", "Giá trị Discount không đúng");

        softAssert.assertAll();
    }
}
