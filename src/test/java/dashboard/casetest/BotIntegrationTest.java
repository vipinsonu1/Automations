package dashboard.casetest;

import com.km.base.TestBase;
import com.km.pages.*;
import com.km.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BotIntegrationTest extends TestBase {
    TestUtil testUtil;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    BotSections botSections;
    BotIntegrationPage botIntegrationPage;
    public BotIntegrationTest() { super(); }
    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil =new TestUtil();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginToDashboard("vipin+testkm28012021@kommunicate.io", "Vipin123");
        botSections = dashboardPage.clickBotSections();
        botIntegrationPage =botSections.clickOnBotIntegration();
    }
    @Test(priority = 1)
    public void verifyintegratedialogflowES() throws InterruptedException {
        botIntegrationPage.integratedialogflowES();
    }
   /* @AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}
