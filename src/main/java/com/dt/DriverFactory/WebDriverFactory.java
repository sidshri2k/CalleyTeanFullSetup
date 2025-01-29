package com.dt.DriverFactory;

import com.dt.Base.Base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.dt.Utils.ConfigReader;

public class WebDriverFactory  extends Base {
    public static org.openqa.selenium.WebDriver driver;

    public static org.openqa.selenium.WebDriver getDriverInstance() {
        if (ConfigReader.getBrowser().equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (ConfigReader.getBrowser().equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (ConfigReader.getBrowser().equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("No compatible browser found.");
        }
        return driver;
    }
}
