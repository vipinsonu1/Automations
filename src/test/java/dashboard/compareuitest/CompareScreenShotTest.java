package dashboard.compareuitest;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.km.base.TestBase;
import compareui.DashboardSnapShot;
import compareui.DataProviderScreenShot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompareScreenShotTest extends TestBase {
    DashboardSnapShot dashboardSnapShot;


    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @Test(dataProvider = "takeshots", priority = 1, dataProviderClass = DataProviderScreenShot.class)
    public void compareImages(String imagename, String url) throws InterruptedException, IOException {
        driver.get(url);
        Thread.sleep(5000);
        // File image=new File(System.getProperty("user.dir") + "/screenshots/Expected1.png");
        File image = new File(System.getProperty("user.dir") + "/screenshots/" + imagename + ".png");
        BufferedImage expectedImage = ImageIO.read(image);
        boolean status = Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 500, true).withName("Actual").equals(expectedImage, 0.1);
        Thread.sleep(5000);
        Assert.assertTrue(status);
    }


    @Test(dataProvider = "dashboardshots", priority = 2, dataProviderClass = DataProviderScreenShot.class)
    public void compareImagesInside(String imagename, String url) throws InterruptedException, IOException {
        dashboardSnapShot =new DashboardSnapShot();
        dashboardSnapShot.loginToDashboard("vipin+agkm210820202@applozic.com", "Vipin123");
        Thread.sleep(4000);
        driver.get(url);
        Thread.sleep(7000);
        File image = new File(System.getProperty("user.dir") + "/screenshots/" + imagename + ".png");
        BufferedImage expectedImage = ImageIO.read(image);
        boolean status = Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 500, true).withName("Actual").equals(expectedImage, 0.1);
        Thread.sleep(3000);
        Assert.assertTrue(status);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}