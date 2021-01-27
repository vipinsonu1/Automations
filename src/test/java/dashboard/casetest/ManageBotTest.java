package dashboard.casetest;

import com.km.base.TestBase;
import com.km.pages.*;
import com.km.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManageBotTest extends TestBase {
    TestUtil testUtil;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    BotSections botSections;
    ManageBot manageBot;
    public ManageBotTest() { super(); }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil =new TestUtil();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginToDashboard("vipin+testkm01012018@kommunicate.io", "abcdef");
        botSections = dashboardPage.clickBotSections();
        manageBot =botSections.clicOnManageBot();
    }

    @Test(priority = 1)
    public void verifyContentPageTest() {
        int coloum = manageBot.gettingNumberOfColoum();
        System.out.println(coloum);
    }

    @Test(priority = 2)
    public void verifyContentPageTest2() {
        manageBot.gettingNumberOfRowName();
    }
    @Test(priority = 3)
    public void verifyeditKomposeTest() throws InterruptedException {
        manageBot.editKompose();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
