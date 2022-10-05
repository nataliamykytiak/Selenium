package config;

import test.TestNGDemo;

import java.io.*;
import java.util.Properties;

/**
 * @author Natalia Mykytiak
 */
public class PropertiesFile {

    static Properties properties = new Properties();

    public static void main(String[] args) {
        getProperties();
        setProperties();

    }

    public static void getProperties(){
        try {
            InputStream input = new FileInputStream("/home/vasyl/IdeaProjects/Selenium/src/test/java/config/config.properties");
            properties.load(input);
            String browser = properties.getProperty("browser");
            System.out.println(browser);
            TestNGDemo.browserName = browser;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }


    public static void setProperties(){
        try {
            OutputStream output = new FileOutputStream("/home/vasyl/IdeaProjects/Selenium/src/test/java/config/config.properties");
            properties.setProperty("result", "pass");
            properties.store(output, null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}
