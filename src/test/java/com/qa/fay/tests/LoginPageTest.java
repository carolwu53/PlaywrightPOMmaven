package com.qa.fay.tests;

import com.qa.fay.base.BaseTest;
import com.qa.fay.constants.AppConstants;
import com.qa.fay.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTest extends BaseTest {
//    LoginPage loginPage;
//    Properties prop;

    @Test(priority = 1)
    public void loginPageNavigationTest() {
        loginPage = homePage.navigateToLoginPage();
        String actLoginPageTitle = loginPage.getLoginPageTitle();
        System.out.println("page act title: " + actLoginPageTitle);
        Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @Test(priority = 3)
    public void appLoginTest() {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
    }

}
