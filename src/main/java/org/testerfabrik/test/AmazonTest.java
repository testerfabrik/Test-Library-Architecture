package org.testerfabrik.test;

import org.openqa.selenium.WebDriver;
import org.testerfabrik.commons.CommonMethods;
import org.testerfabrik.commons.HomeMethods;
import org.testerfabrik.commons.SignUpMethods;
import org.testerfabrik.utils.BrowserType;
import org.testerfabrik.utils.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {

    WebDriver driver;
    SignUpMethods signUpMethods;
    HomeMethods homeMethods;

    @BeforeTest
    public void setUp(){
        this.driver = DriverFactory.getInstance().setDriver(BrowserType.CHROME);
        signUpMethods = new SignUpMethods(driver);
        homeMethods = new HomeMethods(driver);
        signUpMethods.navigateToAmazon();
    }

    @AfterTest
    public void tearDown(){
        DriverFactory.getInstance().removeDriver();
    }

    @Test(priority = 0)
    public void userSignUp(){
        homeMethods.navigeteToSignUp();
        signUpMethods.signUp(CommonMethods.randomInfo("Gil"),CommonMethods.randomInfo("gilberto.aspros+")+"@gmail.com","Test619");
        Assert.assertTrue(homeMethods.verifyUserNameIncludes("Gil"));
    }

    @Test (priority = 1)
    public void searchIpadAirRefining(){
        homeMethods.searchIpadAir("ipad air 2 case", "20", "100");
        Assert.assertTrue(homeMethods.findFirstFiveElements());
    }
}
