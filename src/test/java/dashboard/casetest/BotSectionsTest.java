package dashboard.casetest;

import com.km.base.TestBase;
import com.km.pages.BotSections;
import com.km.pages.DashboardPage;
import com.km.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BotSectionsTest  extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    BotSections botSections;

    public BotSectionsTest()  { super(); }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginToDashboard("vipin+testkm01012018@applozic.com", "abcdef");
        botSections=dashboardPage.clickBotSections();
    }
    @Test(priority = 1)
    public void verifyBotIntegrations() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        String botIntegrationText = botSections.verifyBotIntegrations();
        System.out.println(botIntegrationText);
    }
    @Test(priority = 2)
    public void verifyManageBots() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        String manageText = botSections.verifyManageBots();
        System.out.println(manageText);
    }
    @Test(priority = 3)
    public void verifykompose() {
        String komposeText = botSections.verifykompose();
        System.out.println(komposeText);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
