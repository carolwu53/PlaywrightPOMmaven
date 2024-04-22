package com.qa.fay.base;

import com.qa.fay.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Page;

import com.qa.fay.factory.PlaywrightFactory;
import com.qa.fay.pages.HomePage;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;

    protected HomePage homePage;
    protected LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName){
        pf = new PlaywrightFactory();
        prop = pf.init_prop();

        if(browserName != null)
          prop.setProperty("browser", browserName);

        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
