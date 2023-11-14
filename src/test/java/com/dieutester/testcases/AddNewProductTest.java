package com.dieutester.testcases;

import com.dieutester.common.BaseTest;
import com.dieutester.constants.*;
import com.dieutester.pages.*;
import org.testng.annotations.Test;

import static com.dieutester.constants.ConfigData.*;

public class AddNewProductTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AddNewProductPage addNewProductPage;
    InHouseProductsPage inHouseProductsPage;
    EditProductPage editProductPage;


//    @Test(priority = 1)
//    public void testAddNewProduct() {
//        //Login
//        loginPage = new LoginPage();
//        homePage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
//        loginPage.verifyLoginSuccess();
//
//        //Cick on menu Add New Product
//        addNewProductPage = homePage.clickMenuAddNewProduct();
//
//        //Verify Add New Product Page
//        addNewProductPage.verifyHeaderAddNewProductPage();
//
//        //Input data
//        inHouseProductsPage = addNewProductPage.inputFormData(PRODUCT_NAME);
//    }

    @Test(priority = 2)
    public void checkProductJustAddedIsDisplayedInTheList() {
        //Login
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //Cick on menu Add New Product
        addNewProductPage = homePage.clickMenuAddNewProduct();

        //Verify Add New Product Page
        addNewProductPage.verifyHeaderAddNewProductPage();

        //Input data
        inHouseProductsPage = addNewProductPage.inputFormData(PRODUCT_NAME);

       //Check Product Just Added Is Displayed In The List
        inHouseProductsPage.searchAndVerifyProduct(PRODUCT_NAME);
        editProductPage = inHouseProductsPage.clickButtonEditProduct();
        editProductPage.verifyProductsDetail(PRODUCT_NAME);

    }
}
