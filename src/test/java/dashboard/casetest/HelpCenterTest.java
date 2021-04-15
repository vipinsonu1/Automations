package dashboard.casetest;

import com.km.base.TestBase;
import com.km.pages.DashboardPage;
import com.km.pages.HelpcenterSections;
import com.km.pages.LoginPage;
import com.km.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelpCenterTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TestUtil testUtil;
    HelpcenterSections helpcenterSectionsPage;
    public HelpCenterTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil =new TestUtil();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginToDashboard("vipin+testkm01012018@applozic.com", "abcdef");
        helpcenterSectionsPage =dashboardPage.clickFaqSections();
    }

    @Test(priority = 1)
    public void verifyContentPageTest() {
        String contentText = helpcenterSectionsPage.verifyContentPageText();
        Assert.assertEquals(contentText, "Content", "you are not landing right page");
    }


    @Test(priority = 2)
    public void verifyNewCatagoryTest() {

        Assert.assertTrue(helpcenterSectionsPage.verifyNewCatagory() ,"New Catagorye page is messing");
    }



    @Test(priority = 3)
    public void verifyCustomizationTest() {
        String customizationText = helpcenterSectionsPage.verifyCustomization();
        Assert.assertEquals(customizationText, "Customization", "you are not landing right page");
    }


    @Test(priority = 4)
    public void verifyanswerBotTest() {
        String answerBotText = helpcenterSectionsPage.verifyanswerBot();
        Assert.assertEquals(answerBotText, "Answer Bot", "you are not landing right page");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
