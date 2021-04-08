package dashboard.casetest;

import com.km.base.TestBase;
import com.km.pages.DashboardPage;
import com.km.pages.LoginPage;
import com.km.pages.SettingSection;
import com.km.util.TestUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SettingSectionTest  extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    SettingSection settingSection;
    TestUtil testUtil;
    public SettingSectionTest()  { super(); }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginToDashboard("vipin+testkm01012018@kommunicate.io", "abcdef");
        settingSection=dashboardPage.clickSettingSection();
    }
    @Test(priority = 1)
    public void verifySettingsText() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        String settingsText = settingSection.verifySettings();
        System.out.println(settingsText);
    }
}
