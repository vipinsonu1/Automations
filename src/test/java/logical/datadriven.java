package logical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class datadriven {

    public static  void main(String[] args ) throws IOException {
        FileReader readfile=new FileReader("/Users/vipinpandey/Downloads/Testfile/log.txt");
        BufferedReader  br =new BufferedReader(readfile);
        int count=0;
        int iteration=-1;
        String line;
        while ((line = br.readLine()) !=null){
            count=count+1;
            iteration=iteration+1;
            if (count>1){
                String [] Inputdata=line.split(",",2);

                System.setProperty("webdriver.chrome.driver", "/Users/vipinpandey/Documents/testingtools/chromedriver");
                WebDriver driver =new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("http://www.gcrit.com/build3/admin");
                driver.findElement(By.name("username")).sendKeys(Inputdata[0]);
                driver.findElement(By.name("password")).sendKeys(Inputdata[1]);
                driver.findElement(By.id("tdb1")).click();
             String URL =driver.getCurrentUrl();
             if(URL.contains("http://www.gcrit.com/build3/admin/index.php"))
             {
                 System.out.println("Admin login successfull: Passed");
             }
              else
             {
                 System.out.println("Admin login successfull: failed");

             }

                driver.close();
            }

        }

     /*   System.setProperty("webdriver.chrome.driver","");
        WebDriver driver =new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("");
        driver.findElement(By.id("")).sendKeys("userName");
        driver.findElement(By.id("")).sendKeys("password");
        driver.findElement(By.id("")).click();
*/
       br.close();
       readfile.close();

    }
}
