package logical;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class javascriptExce {

    @FindBy(id = "kommunicate-widget-iframe")
    WebElement WIDGET;
    @FindBy(id = "mck-sidebox-launcher")
    WebElement launchWidget;
    @FindBy(id = "hat-popup-widget-container")
    WebElement WidgetContainer;
    public static final String WEB_JAVA_SCRIPT = " (function(d, m){\n" +
            "        var kommunicateSettings = \n" +
            "            {\"appId\":\"14d4ba62306d657d0c5170928d94a7ce0\",\"popupWidget\":true,\"automaticChatOpenOnNavigation\":true};\n" +
            "        var s = document.createElement(\"script\"); s.type = \"text/javascript\"; s.async = true;\n" +
            "        s.src = \"https://widget-test.kommunicate.io/v2/kommunicate.app\";\n" +
            "        var h = document.getElementsByTagName(\"head\")[0]; h.appendChild(s);\n" +
            "        window.kommunicate = m; m._globals = kommunicateSettings;\n" +
            "    })(document, window.kommunicate || {});";

    @Test
    public void main() throws InterruptedException {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "/Users/vipinpandey/Documents/testingtools/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.base64decode.org/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        driver.get(baseUrl);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(WEB_JAVA_SCRIPT);

        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        Thread.sleep(10000);
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));

        System.out.println("total number of frame " + elements.size());
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(i);
        }

        WebDriverWait w = new WebDriverWait(driver, 50);
        w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("kommunicate-widget-iframe"));
        WebElement p = driver.findElement(By.cssSelector("body"));
        System.out.println("Text inside frame is: " + p.getText());
        Thread.sleep(3000);
        WebElement ele = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mck-sidebox-launcher']")));
        ele.click();
        Thread.sleep(3000);
        WebElement sendtext = w.until(ExpectedConditions.visibilityOfElementLocated(By.id("mck-text-box")));
        sendtext.sendKeys("hi");
        Thread.sleep(3000);
        WebElement send = w.until(ExpectedConditions.visibilityOfElementLocated(By.id("mck-msg-sbmt")));
        send.click();

    }

  /*  public void sendMessage() {
        WebElement send = w.until(ExpectedConditions.visibilityOfElementLocated(By.id("mck-msg-sbmt")));
        send.click();
    }
*/
    @Test(invocationCount = 5)
    public void sampleTest() throws Exception {
        System.out.println("Foo.");
        Thread.sleep(2000);
    }

}
