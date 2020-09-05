package com.km.pages;

import com.km.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpcenterSections extends TestBase {

    @FindBy(xpath = "//a[contains(text(),'Content')]")
    WebElement contentText;
    @FindBy(xpath = "//a[contains(text(),'Customization')]")
    WebElement customizationText;
    @FindBy(xpath = "//a[contains(text(),'Answer Bot')]")
    WebElement answerBotText;
    @FindBy(xpath = "//div[@class='sc-hZSUBg ikyXnl animated fadeIn']")
    WebElement newCatagory;



    public HelpcenterSections() {
        PageFactory.initElements(driver, this);
    }

    public String verifyContentPageText() {
        return contentText.getText();
    }

    public boolean verifyNewCatagory() {
        return newCatagory.isDisplayed();
    }

    public String verifyCustomization() {
        return customizationText.getText();
    }

    public String verifyanswerBot() {
        return answerBotText.getText();
    }
}
