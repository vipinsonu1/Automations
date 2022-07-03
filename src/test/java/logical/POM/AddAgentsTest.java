package logical.POM;

import com.km.base.TestBase;
import com.km.util.TestUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddAgentsTest extends TestBase {
    TestUtil testUtil;
    public AddAgentsTest() { super(); }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil =new TestUtil();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }


    @Test
    public void testLogin() {
        SignInPage signInPage = new SignInPage(driver);
        TeammatePage teammatepage = signInPage.loginValidUser("vipin+testkm24052022@kommunicate.io", "Vipin123");
         teammatepage.clickTeammate();
    }

    @Test
    public void testDashboard(){
        TeammatePage teammatepage= new TeammatePage(driver);
        //teammatepage.
    }

}
