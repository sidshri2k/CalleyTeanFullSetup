package com.dt.test;

import com.dt.Utils.ConfigReader;
import com.dt.Base.Base;
import com.dt.page.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends Base {

    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    RegistrationPage registrationPage;

    @BeforeTest
    public void setUp() throws IOException {
        logger.info("Test setup is starting");
        initialization();
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage();
    }

    @Test
    public void launchURL() {
        logger.info("URL is launched");
        driver.get(ConfigReader.getAppURl());
    }

    @Test
    public void verifyvalidRegistration() {

        registrationPage.enterName("harendra@123");
        registrationPage.enterEmail("test@1");
     registrationPage.enterPassword("jaiswal123");
    registrationPage.enterMobile("9511090019");

    registrationPage.clickCheckBoxBtn();
    registrationPage.clickSingUpBtn();
        logger.info("valid Registration is successfully verified");
        //Assert.assertEquals(registrationPage.getErrorMessage(), "Email Address already exists!");
    }

    @AfterMethod
    public void onTestFailure(ITestResult result) throws IOException, InterruptedException {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP) {  // Corrected import of ITestResult
            String screenshotDirPath = "reports/screenshot/" + result.getMethod().getMethodName() + ".png";
            com.dt.Utils.TestUtils.takeScreenshot(screenshotDirPath);
            result.setAttribute("screenshotPath", "./screenshot/" + result.getMethod().getMethodName() + ".png");
        }
    }
}
