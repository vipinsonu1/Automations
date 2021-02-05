package com.km.pages;

import com.km.base.TestBase;
import com.km.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManageBot  extends TestBase {
    @FindBy(xpath = "//div[@class='row']//div")
    List<WebElement> COLOUM;
    String ROW_BEFORE_XPATH="//*[@id='root']/div/div[2]/div/main/div[3]/div/div[2]/div[3]/div[";
    String ROW_AFTER_XPATH="]";
    String ROWS="//*[@id='root']/div/div[2]/div/main/div[3]/div/div[2]/div[3]/div";
    @FindBy(xpath = "//div[4]//div[4]//span[2]")
    WebElement KOMPOSE;
    @FindBy(xpath = "//input[contains(@placeholder,'Example: Alex, Bot')]")
    WebElement BOT_NAME;
    @FindBy(xpath = "//div[@class='BotStyledStep2__BotIconWrapper-sc-7ins27-7 itRSFU']//div[2]")
    WebElement BOT_IMAGE;
    @FindBy(xpath = "//button[normalize-space()='Save and proceed']")
    WebElement BOT_SAVE;

    Actions action = new Actions(driver);

    public ManageBot() { PageFactory.initElements(driver, this); }

    public int  gettingNumberOfColoum() {
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return COLOUM.size();
    }

    public int gettingNumberOfRow() {
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
       List <WebElement> row=driver.findElements(By.xpath(ROWS));
       int rowsCount=row.size();
       return rowsCount;
    }
    public  WebElement gettingNumberOfRowName() {
        WebElement element=null;
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        for (int i = 2; i<=gettingNumberOfRow(); i++)
        {
            String actualrowXpath= ROW_BEFORE_XPATH + i + ROW_AFTER_XPATH;
            element = driver.findElement(By.xpath(actualrowXpath));

            if(element.getText().equals("BookTrip-abhinav\nbooktrip-qzy4j\nAmazon Lex"))
            {
                System.out.println("Bot Name: "+ element.getText());

                break;
            }
            System.out.println(element.getText());
        }
        return element;
    }
    
    public void editKompose() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        action.moveToElement(KOMPOSE).click().build().perform();
        BOT_NAME.clear();
        BOT_NAME.sendKeys("editName");
        Thread.sleep(2000);
        BOT_IMAGE.click();
        BOT_SAVE.click();
    }

}
