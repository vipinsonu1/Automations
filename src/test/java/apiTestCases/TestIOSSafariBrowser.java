package apiTestCases;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

    public class TestIOSSafariBrowser {

        @Test
        public void startBrowser() throws MalformedURLException {

            // Create Object of DesiredCapability class
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Set the device Name- You can change based on your requirement
            capabilities.setCapability("deviceName", "iPhone 6");

            // Set the platform name- This will ramain same
            capabilities.setCapability("platformName", "iOS");

            // This the version- it is important so change it if required
            capabilities.setCapability("platformVersion", "9.1");

            // set the browser in Emulator
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");

            // pass the capability object and start the session
            IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            // Open any web application which you want to Test
            driver.get("http://learn-automation.com");

            // Perform any operation- In my case I just used title of Page.
            System.out.println("Page title is " + driver.getTitle());

        }

    }

