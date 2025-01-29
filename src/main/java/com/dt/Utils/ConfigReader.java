package com.dt.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    public final static String Confingfilepath= "src/main/resources/Config.properties";

    public static void initialization() throws IOException {
        prop = new Properties();
        prop.load(new InputStreamReader(new FileInputStream(new File(Confingfilepath))));
    }

    public static String getAppURl() {
        return prop.getProperty("appURL");
    }

    public static String getBrowser() {
        return prop.getProperty("browser");
    }
}
