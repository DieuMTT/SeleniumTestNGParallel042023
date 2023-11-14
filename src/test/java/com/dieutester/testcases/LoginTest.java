package com.dieutester.testcases;


import com.dieutester.common.BaseTest;
import com.dieutester.constants.ConfigData;
import com.dieutester.keywords.WebUI;
import com.dieutester.pages.HomePage;
import com.dieutester.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLoginSuccess");
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithEmailInvalid");
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS("admin@example.com", "123");
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithPasswordInvalid");
    }
}
