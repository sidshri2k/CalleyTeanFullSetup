package com.dt.Base;

import com.dt.DriverFactory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import com.dt.Utils.ConfigReader;

import java.io.IOException;

public class Base {
    public static WebDriver driver;

    public static void initialization() throws IOException {
        ConfigReader.initialization();

        driver = WebDriverFactory.getDriverInstance();

    }
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
