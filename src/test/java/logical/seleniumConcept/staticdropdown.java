package logical.seleniumConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class staticdropdown {

    @Test
    public void staticdrop(){
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement findCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown= new Select(findCurrency);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());


    }
    @Test
    public void passanger() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(3000);
        int i=1;
        while (i<5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
              }
      /*  for(int i=1;i<5;i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }*/
        driver.findElement(By.id("btnclosepaxoption")).click();




    }

    @Test
    public void dynamicdrop() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BHO']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();



    }
    @Test
    public void autodayamic() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options =driver.findElements(By.cssSelector("li[class*='ui-menu-item'] a"));
        for (WebElement option:options)
        {
            if (option.getText().equalsIgnoreCase("India")){
                option.click();
            }
        }

    }

    @Test
    public void checkBox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        List<WebElement> checkBox= driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkBox.size());

    }

    @Test
    public void assignmentChk() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        List<WebElement> checkBox= driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkBox.size());

    }


    @Test
    public void currentDateSelect() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BHO']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        Thread.sleep(2000);
       // driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
       System.out.println( driver.findElement(By.id("Div1")).getAttribute("style"));
       driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
       if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
       {
           System.out.println("Its enabled");
           Assert.assertTrue(true);

       }
       else {
           Assert.assertTrue(false);
       }

    }

    @Test
    public void Assigment2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/vipinpandey/Documents/testingtools/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://www.cleartrip.com/");
        driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("div[aria-label='Sun Nov 07 2021']")).click();
        Thread.sleep(2000);
        WebElement adult= driver.findElement(By.xpath("//div[@class='mb-4']//select[@class='bc-neutral-100 bg-transparent']"));
        Select dropdown= new Select(adult);
        dropdown.selectByValue("3");
        WebElement childrn=driver.findElement(By.xpath("//div[3]//select[1]"));
        Select dropdown1= new Select(childrn);
        dropdown1.selectByValue("3");
        driver.findElement(By.xpath("//div[@class='mb-4']//a")).click();
        driver.findElement(By.xpath("//div[@class='p-relative']//input[@placeholder='Airline name']")).sendKeys("indigo");
        driver.findElement(By.xpath("//button[.='Search flights']")).click();
        System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Select Departure and Arrival airports/cities.')]")).getText());

    }
}
