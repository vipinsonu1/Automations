package dashboard.casetest;

import com.km.base.TestBase;
import com.km.pages.DashboardPage;
import com.km.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;


    public DashboardPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginToDashboard("vipin+testkm01012018@applozic.com", "abcdef");

    }

    @Test(priority = 1)
    public void verifydashboardPageTest() {
        String dashboardText = dashboardPage.verifydashboardPage();
        Assert.assertEquals(dashboardText, "Dashboard", "you are not landing right page");
    }

    @Test(priority = 3)
    public void verifyDashboardBotTextTest() {
        String botText = dashboardPage.verifyDashboardBotText();
        Assert.assertEquals(botText, "Bots", "Bot text is not matching in the dashboard");
    }

    @Test(priority = 2)
    public void verifyDashboardTeammateTextTest() {
        String teammatesText = dashboardPage.verifyDashboardTeammateText();
        Assert.assertEquals(teammatesText, "Teammates", "Bot text is not matching in the dashboard");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
