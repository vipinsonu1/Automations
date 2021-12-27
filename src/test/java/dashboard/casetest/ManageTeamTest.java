package dashboard.casetest;

import com.km.base.TestBase;
import com.km.pages.DashboardPage;
import com.km.pages.LoginPage;
import com.km.pages.TeammateSectionPage;
import org.testng.annotations.BeforeTest;

public class ManageTeamTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TeammateSectionPage teammateSectionPage;

    public ManageTeamTest() {
        super();
    }


    @BeforeTest
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginToDashboard("vipin+testkm01012018@applozic.com", "abcdef");

    }

}
