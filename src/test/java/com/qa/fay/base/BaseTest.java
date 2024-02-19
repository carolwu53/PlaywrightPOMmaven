package com.qa.fay.base;

import com.qa.fay.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Page;

import com.qa.fay.factory.PlaywrightFactory;
import com.qa.fay.pages.HomePage;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;

    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
