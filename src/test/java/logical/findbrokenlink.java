package logical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class findbrokenlink {

     @Test
    public  void test () throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://test.kommunicate.io/");
        Thread.sleep(5000);
        List<WebElement> links= driver.findElements(By.tagName("a"));
        System.out.println("total link of page "+ links.size());
        for(int i=0; i<links.size();i++)
        {
            System.out.println(i);

            WebElement element = links.get(i);
            String url=element.getAttribute("href");
            verifylink(url);

        }
    }
    public  static void verifylink(String urllink)
    {
      try
      {
      URL link= new URL(urllink);

              HttpURLConnection httpconn= (HttpURLConnection)link.openConnection();
          httpconn.setConnectTimeout(2000);
          httpconn.connect();
          if(httpconn.getResponseCode()==200){
              System.out.println(urllink+" - "+httpconn.getResponseMessage());

          }
          if (httpconn.getResponseCode()==400){
              System.out.println(urllink+" - "+httpconn.getResponseMessage());

          }


      }
      catch ( Exception e)
      {
          e.printStackTrace();
      }
    }
}
