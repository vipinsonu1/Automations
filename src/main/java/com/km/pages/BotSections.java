package com.km.pages;

import com.km.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BotSections extends TestBase {
    @FindBy(xpath = "//a[contains(text(),'Bot Integrations')]")
    WebElement botIntegrations;

    @FindBy(xpath = "//a[contains(text(),'Manage Bots')]")
    WebElement manageBots;
    @FindBy(xpath= "//a[contains(text(),'Kompose')]")
    WebElement kompose;

    public BotSections() {
        PageFactory.initElements(driver, this);
    }


    public BotIntegrationPage clickOnBotIntegration() {
        botIntegrations.click();
        return new BotIntegrationPage();
    }


    public ManageBot clicOnManageBot() {
        manageBots.click();
        return new ManageBot();
    }

    public Kompose clickOnKompose() {
           kompose.click();
           return new Kompose();
    }

    public String verifyBotIntegrations() { return botIntegrations.getText(); }
    public String verifyManageBots() { return manageBots.getText(); }
    public String verifykompose() { return kompose.getText(); }



}

