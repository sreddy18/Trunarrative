package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    /**
     * property file in the project
     **/
    private final String propertyFilePath = "configs//Configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to read the driver path from configuration prperties
     **/
    public String getDriverPath() throws Exception {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new Exception("driverPath not specified in the configuration properties");
    }

    /**
     * Method to read implict wait from configuration properties
     **/
    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implictly wait not specified in the configuration");
    }

    /**
     * Method to read url form the configuration properties
     **/
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified");
    }

    /**
     * Method to read browser value from configuration
     **/
    public String getBrowserType() {
        String browser = properties.getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("browser type undefined");
    }
}


