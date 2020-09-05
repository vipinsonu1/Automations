package framework.keywords.engine;

import framework.keywords.base.Base;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class KeywordEngine {
  public Base base;
  public WebElement element;
    public static WebDriver driver;
    public static Properties prop;
    public static Workbook book;
    public  static Sheet sheet;
    public final String SCENARIO_SHEET_PATH= System.getProperty("user.dir") + "/data/Screenshot.xlsx";
    public  void startExecution(String sheetName){
        String locatorName=null;
        String locatorValue=null;
        FileInputStream file=null;
        try {
            file =new FileInputStream(SCENARIO_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book=WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet=book.getSheet(sheetName);
        int k=0;
        for (int i=0;i<sheet.getLastRowNum();i++) {
            try {
                String locatorColValue = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
                if (!locatorColValue.equalsIgnoreCase("NA")) {
                    locatorName = locatorColValue.split("=")[0].trim();
                    locatorValue = locatorColValue.split("=")[1].trim();
                }
                String action = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
                String value = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
                switch (action) {
                    case "open browser":
                        base = new Base();
                        prop = base.init_properties();
                        Thread.sleep(5000);
                        if (value.isEmpty() || value.equals("NA")) {
                            driver = base.init_driver(prop.getProperty("browser"));
                        } else {
                            driver = base.init_driver(value);
                        }
                        break;
                    case "enter url":
                        if (value.isEmpty() || value.equals("NA")) {
                            driver.get(prop.getProperty("url"));
                        } else {
                            driver.get(value);
                        }
                        break;
                    case "quit":
                        Thread.sleep(5000);
                        driver.quit();
                        break;

                    default:
                        break;
                }
                switch (locatorName) {
                    case "id":
                        element = driver.findElement(By.id(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.clear();
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        }
                        locatorName = null;
                        break;
                    case "linkText":
                        element = driver.findElement(By.linkText(locatorValue));
                        element.click();
                        locatorName = null;
                        break;
                    case "xpath":
                        element = driver.findElement(By.xpath(locatorValue));
                        element.click();
                        locatorName = null;
                        break;
                    case "className":
                        element = driver.findElement(By.className(locatorValue));
                        element.click();
                        locatorName = null;
                        break;
                    case "name":
                        element = driver.findElement(By.name(locatorValue));
                        element.click();
                        locatorName = null;
                        break;
                    case "css":
                        element = driver.findElement(By.cssSelector(locatorValue));
                        element.click();
                        locatorName = null;
                        break;
                    case "partialLinkText":
                        element = driver.findElement(By.partialLinkText(locatorValue));
                        element.click();
                        locatorName = null;
                        break;
                    default:
                        break;
                }

            }
            catch (Exception e){

            }
        }

    }


}
