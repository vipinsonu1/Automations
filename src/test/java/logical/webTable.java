package logical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class webTable {

    static WebDriver driver;

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://www.w3schools.com/html/html_tables.asp");

         System.out.println(getRowCalNumber("Germany"));

    }

    public static boolean getRowCalNumber(String name){
        int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int callCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
        boolean flag = false;
        for(int i=1; i<rowCount; i++){
            for(int j=1; j<=callCount; j++){
                String actValue = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
                if(actValue.equals(name)){
                    flag =true;
                    System.out.println(i +" : " + j);
                    break;
                }
            }
        }
        if(flag){
            return true;
        }
        return flag;

    }

}
