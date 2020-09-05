package dashboard.casetest;

import com.km.base.TestBase;
import com.km.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.km.pages.DashboardPage;

public class LoginPageTest extends TestBase {


    LoginPage loginPage;

    DashboardPage dashboardPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }


    @Test(priority = 0)
    public void verifiedLoginTitle() {
        String titleName = loginPage.getLoginTitle();
        Assert.assertEquals(titleName, "Login to Kommunicate");
    }

    @Test(priority = 1)
    public void verifiedLoginPage() {
        boolean flag = loginPage.validateLoginPage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public DashboardPage loginTest() {
        dashboardPage = loginPage.loginToDashboard("vipin+testkm01012018@applozic.com", "abcdef");

        return new DashboardPage();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
