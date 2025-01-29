package com.dt.page;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePageAction{

    String locatorTextYourName="#txtName";
    String locatorTextYourEmailID ="#txtEmail";
    String locatorTextFieldPassword ="input[name=\"txtPassword\"]";
    String locatorYourMobileNumber="input[name=\"txt_mobile\"]";

    String locatorCaptchCode="#recaptcha-anchor-label";
    String locatorCheckBoxPrivacy="label[class=\"text-muted\"]";
    String locatorBTnSingUp="#btnSignUp";




    public void enterName(String name) {
        driver.findElement(By.cssSelector(locatorTextYourName)).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(By.cssSelector(locatorTextYourEmailID)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.cssSelector(locatorTextFieldPassword)).sendKeys(password);
    }



    public void enterMobile(String Mobile) {
        driver.findElement(By.cssSelector(locatorYourMobileNumber)).sendKeys(Mobile);
    }

    public void clickCpatcha() {
        clickElement(locatorCaptchCode);
    }

    public void clickCheckBoxBtn() {
        clickElement(locatorCheckBoxPrivacy);
    }
    public void clickSingUpBtn() {
        clickElement(locatorBTnSingUp);
    }
}
