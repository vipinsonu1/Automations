package compareui;

import com.km.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardSnapShot extends TestBase {

    @FindBy(id = "email-input-field")
    WebElement email;

    @FindBy(xpath = "//input[@class='input']")
    WebElement passwoard;

    @FindBy(id = "login-button")
    WebElement login;

    @FindBy(xpath = "//div[@id='application-list-main-container']//div[1]")
    WebElement appsList;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/nav/ul[1]/li[2]/a")
    WebElement dashboard;

    @FindBy(xpath = "//*[@id=\"root\"] //a[contains(@href,'/conversations')]")
    WebElement conversations;

    @FindBy(xpath = "//a[contains(@href,'/users')]")
    WebElement users;

    @FindBy(xpath = "//a[@id='ac-bot-integrations']")
    WebElement botintegrations;

    @FindBy(xpath = "//a[@id='ac-integrations']")
    WebElement integrations;

    @FindBy(xpath = "//a[@id='ac-faq']")
    WebElement faq;

    public DashboardSnapShot() {
        PageFactory.initElements(driver, this);
    }

    public void openDashboard() { dashboard.click(); }

    public void openConversations() {
        conversations.click();
    }

    public void openUsers() {
        users.click();
    }

    public void openBotIntegrations() {
        botintegrations.click();
    }

    public void openIntegrations() {
        integrations.click();
    }

    public void openFaq() {
        faq.click();
    }
    public void clickLogin() {
        login.click();
    }

    public DashboardSnapShot loginToDashboard(String strUserName, String strPassword) {
        email.sendKeys(strUserName);
        passwoard.sendKeys(strPassword);
        clickLogin();
        return new DashboardSnapShot();
    }

}
