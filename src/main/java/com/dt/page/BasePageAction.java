package com.dt.page;

import com.dt.Base.Base;
import org.openqa.selenium.By;
import com.dt.Utils.ConfigReader;

public class BasePageAction extends Base {

    public static void launchURL() {
        driver.get(ConfigReader.getAppURl());
    }

    public static void clickElement(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public static void sendKeysToElement(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public static String getTextFromElement(String locator) {
        return driver.findElement(By.cssSelector(locator)).getText();
    }

    public static String getApplicationURL() {
        return driver.getCurrentUrl();
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isElementVisible(String locator) {
        return driver.findElement(By.cssSelector(locator)).isDisplayed();
    }

}
