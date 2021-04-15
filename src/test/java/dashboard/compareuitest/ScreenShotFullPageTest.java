package dashboard.compareuitest;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.km.base.TestBase;
import compareui.DashboardSnapShot;
import compareui.DataProviderScreenShot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class ScreenShotFullPageTest extends TestBase {
    DashboardSnapShot dashboardSnapShot;
    //ScreenShotFullPageTest screenShotFullPageTest;


    public ScreenShotFullPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @Test(dataProvider = "takeshots",priority = 1, dataProviderClass = DataProviderScreenShot.class,enabled = false)
    public  void takeFullPageScreenShot(String imagename, String url ) throws InterruptedException{
        driver.get(url);
        Thread.sleep(7000);
        Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName(imagename).save();
        Thread.sleep(2000);
    }

    @Test(dataProvider = "dashboardshots",priority = 2,dataProviderClass = DataProviderScreenShot.class,enabled = false)
    public  void insideDashboardScreenShot(String imagename, String url ) throws InterruptedException{
        driver.get(url);
        Thread.sleep(7000);
        Shutterbug.shootPage
                (driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName(imagename).save();
        Thread.sleep(2000);
    }


    @Test(priority = 3)
    public void clickDashboard() throws InterruptedException {
        dashboardSnapShot =new DashboardSnapShot();
        dashboardSnapShot.loginToDashboard("vipin+agkm210820202@applozic.com", "Vipin123");
        Thread.sleep(4000);
        dashboardSnapShot.openDashboard();
        Thread.sleep(2000);
        Shutterbug.shootPage
                (driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName("Dashboard").save();
    }

    @Test(priority = 4)
    public void clickConversations() throws InterruptedException {
        dashboardSnapShot =new DashboardSnapShot();
        dashboardSnapShot.loginToDashboard("vipin+agkm210820202@applozic.com", "Vipin123");
        dashboardSnapShot.openConversations();
        Thread.sleep(7000);
        Shutterbug.shootPage
                (driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName("Conversations").save();
        Thread.sleep(2000);
    }


    @Test(priority = 5)
    public void clickUsers() throws InterruptedException {
        dashboardSnapShot =new DashboardSnapShot();
        dashboardSnapShot.loginToDashboard("vipin+agkm210820202@applozic.com", "Vipin123");
        dashboardSnapShot.openUsers();
        Thread.sleep(7000);
        Shutterbug.shootPage
                (driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName("Users").save();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void clickBotIntegrations() throws InterruptedException {
        dashboardSnapShot =new DashboardSnapShot();
        dashboardSnapShot.loginToDashboard("vipin+agkm210820202@applozic.com", "Vipin123");
        dashboardSnapShot.openBotIntegrations();
        Thread.sleep(7000);
        Shutterbug.shootPage
                (driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName("BotIntegrations").save();
        Thread.sleep(2000);
    }
    @Test(priority = 7)
    public void clickIntegrations() throws InterruptedException {
        dashboardSnapShot =new DashboardSnapShot();
        dashboardSnapShot.loginToDashboard("vipin+agkm210820202@applozic.com", "Vipin123");
        dashboardSnapShot.openIntegrations();
        Thread.sleep(7000);
        Shutterbug.shootPage
                (driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName("Integrations").save();
        Thread.sleep(2000);
    }
    @Test(priority = 8)
    public void clickContent() throws InterruptedException {
        dashboardSnapShot =new DashboardSnapShot();
        dashboardSnapShot.loginToDashboard("vipin+agkm210820202@applozic.com", "Vipin123");
        dashboardSnapShot.openFaq();
        Thread.sleep(7000);
        Shutterbug.shootPage
                (driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName("Content").save();
        Thread.sleep(2000);
    }
    @Test(priority = 9)
    public void answerBotScreenShot() throws InterruptedException {
        dashboardSnapShot =new DashboardSnapShot();
        dashboardSnapShot.loginToDashboard("vipin+testkm01012018@kommunicate.io", "abcdef");
        dashboardSnapShot.openFaq();
        driver.navigate().to("https://dashboard-test.kommunicate.io/helpcenter/answer-bot");
        Thread.sleep(7000);
        Shutterbug.shootPage
                (driver, ScrollStrategy.WHOLE_PAGE,500,true)
                .withName("Answer").save();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
