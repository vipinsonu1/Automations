package com.km.pages;

import com.km.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage extends TestBase {
    @FindBy(xpath = "//li[@class='active breadcrumb-item']")
    WebElement dashboardtext;

    @FindBy(xpath = "//a[@class='nav-link active']")
    WebElement dashboardAnlaytics;

    @FindBy(xpath = "//a[@class='nav-link conversation-menu']")
    WebElement conversationSection;

    @FindBy(xpath = "//a[@class='nav-link active']")
    WebElement userSections;

    @FindBy(id = "ac-bot-integrations")
    WebElement botSections;

    @FindBy(id = "ac-integrations")
    WebElement thirdpartyIntegrationSection;

    @FindBy(xpath = "//a[@id='ac-faq']")
    WebElement helpcenterSections;

    @FindBy(xpath = "//li[@class='nav-item']//a[@class='nav-link']")
    WebElement settingSection;

    @FindBy(xpath = "//p[contains(text(),'Bots')]")
    WebElement bottext;

    @FindBy(xpath = "//p[contains(text(),'Teammates')]")
    WebElement teammatestext;

    @FindBy(xpath = "//*[@id='root']/div/div[2]/div/main/div[3]/div/div[1]/div[1]/div/div[1]/div[2]/div/div/div")
    WebElement selectedbot;


    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public DashboardAnlaytics clickDashboardAnlaytics() {
        dashboardAnlaytics.click();
        return new DashboardAnlaytics();
    }


    public ConversationSection clickConversationSection() {
        conversationSection.click();
        return new ConversationSection();
    }


    public UserSections clickUserSections() {
        userSections.click();
        return new UserSections();
    }


    public BotSections clickBotSections() {
        botSections.click();
        return new BotSections();
    }

    public ThirdpartyIntegrationSection clickThirdpartyIntegrationSection() {
        thirdpartyIntegrationSection.click();
        return new ThirdpartyIntegrationSection();
    }

    public HelpcenterSections clickFaqSections() {
        helpcenterSections.click();
        return new HelpcenterSections();
    }


    public SettingSection clickSettingSection() {
        settingSection.click();
        return new SettingSection();

    }

    public String verifydashboardPage() { return dashboardtext.getText(); }

    public String verifyDashboardBotText() {
        return bottext.getText();
    }

    public String verifyDashboardTeammateText() {
        return teammatestext.getText();
    }

}
