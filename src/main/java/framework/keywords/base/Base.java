package framework.keywords.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {


    public static WebDriver driver;
    public static Properties prop;

    public WebDriver init_driver(String browserName) {
        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "/Users/vipinpandey/Documents/testingtools/chromedriver");
            if (prop.getProperty("headless").equals("yes")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("-----headless");
                driver = new ChromeDriver();
            }
            else {
                driver=new ChromeDriver();
            }
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "");
            driver = new FirefoxDriver();
        }
        return driver;
    }
    public  Properties init_properties(){
        prop=new Properties();
        try{
            FileInputStream ip =new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/km/config/object.properties");
            prop.load(ip);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }

}