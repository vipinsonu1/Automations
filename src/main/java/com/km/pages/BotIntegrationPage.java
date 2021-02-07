package com.km.pages;

import com.km.base.TestBase;
import com.km.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BotIntegrationPage  extends TestBase {

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/main[1]/div[3]/div[1]/div[1]/div[2]/div[2]")
    WebElement dialogflowES;

     @FindBy(xpath = "//input[@id='uploadJson']")
     WebElement uploadFile;

     @FindBy(xpath = "//button[contains(text(),'Save and proceed')]")
     WebElement save;

     @FindBy(xpath = "//input[contains(@placeholder,'Example: Alex, Bot')]")
     WebElement botName;

     @FindBy(xpath = "//input[@id='km-upload-bot-image-select']")
     WebElement uploadBotImage;

     @FindBy(xpath = "//button[normalize-space()='Save and proceed']")
     WebElement saveProceed;

     @FindBy(xpath = "//label[@for='km-bot-auto-human-handoff-enabled']//div[@class='RadioButton__RadioButtonChecker-sc-19nlll-3 CQfrv radio-checkmark']")
     WebElement enableThisFeature;

     @FindBy(xpath ="//button[normalize-space()='Finish bot setup']")
     WebElement finishBotSetup;

    public BotIntegrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void integratedialogflowES() throws InterruptedException {
        dialogflowES.click();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        uploadFile.sendKeys("/Users/vipinpandey/Downloads/kommunicate-test-bot-wfsc-2e8512e7cd7f.json");
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        save.click();
        botName.sendKeys("hgvhgh");
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        uploadBotImage.sendKeys("/Users/vipinpandey/Downloads/images.jpeg");
        saveProceed.click();
        Thread.sleep(2000);
        enableThisFeature.click();
        finishBotSetup.click();
    }

}
