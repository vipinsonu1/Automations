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
    @FindBy(xpath = "//*[@id='km-bot-test-scroll-zjx58copy-text']/ancestor::div[contains(@class,'col-3')]/following-sibling::div[contains(@class,'km-bot-edit-delete')]/child::span[contains(text(),'Edit')]")
    WebElement KOMPOSE;
    @FindBy(id = "bot-integration-bot-name")
    WebElement BOT_NAME;
    @FindBy(id = "bot-integration-upload-bot-image-3")
    WebElement BOT_IMAGE;
    @FindBy(xpath = "//button[normalize-space()='Save and proceed']")
    WebElement BOT_SAVE;
    @FindBy(xpath = "//button[contains(text(),'Update bot setup')]")
    WebElement SAVE_UPDATE;
    @FindBy(xpath= "//*[@id='km-new-bot-19-dec-leuctcopy-text']/ancestor::div[contains(@class,'col-3')]/following-sibling::div[contains(@class,'km-bot-edit-delete')]/child::span[contains(@class,'km-test-bot-link')]/a")
    WebElement TestBot;
    @FindBy(xpath= "//*[@id='mck-text-box']")
    WebElement TextBoxWidget;
    @FindBy(xpath ="//iframe[@id='kommunicate-widget-iframe']")
    WebElement Myframe;
    @FindBy(id="mck-msg-sbmt")
    WebElement submit;

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
        SAVE_UPDATE.click();
        driver.get("https://dashboard-test.kommunicate.io/bots/manage-bots");
        TestBot.click();
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("Total number of iframes are " + iframeElements.getClass());
        Myframe.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        TextBoxWidget.clear();
        TextBoxWidget.sendKeys("card");
        submit.click();

    }

}
