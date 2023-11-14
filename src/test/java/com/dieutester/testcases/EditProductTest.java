package com.dieutester.testcases;

import com.dieutester.common.BaseTest;
import com.dieutester.constants.ConfigData;
import com.dieutester.pages.*;
import org.testng.annotations.Test;

import static com.dieutester.constants.ConfigData.PRODUCT_NAME;

public class EditProductTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AddNewProductPage addNewProductPage;
    InHouseProductsPage inHouseProductsPage;
    EditProductPage editProductPage;


    @Test(priority = 1)
    public void testEditProduct() {
        //Login
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);

        //Cick on menu Add New Product
        addNewProductPage = homePage.clickMenuAddNewProduct();

        //Verify Add New Product Page
        addNewProductPage.verifyHeaderAddNewProductPage();

        //Input data
        inHouseProductsPage = addNewProductPage.inputFormData(PRODUCT_NAME);

        //Search
        inHouseProductsPage.searchAndVerifyProduct(PRODUCT_NAME);

        //Verify data
        editProductPage = inHouseProductsPage.clickButtonEditProduct();
        editProductPage.testEditProduct();
        editProductPage.verifyDataProduct(PRODUCT_NAME);
    }
}
