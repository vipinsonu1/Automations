package logical.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeammatePage {
    protected WebDriver driver;

private By SettingsBy=By.xpath("//a[@data-tip='Settings']");
private  By CompanyBY=By.xpath("//h2[normalize-space()='COMPANY']");
private  By teammateBy=By.xpath("//a[normalize-space()='Teammates']");
private By inviteBy=By.id("invite");
private By inviteEmailBy=By.id("email-field");

          public TeammatePage(WebDriver driver)
    {
            this.driver = driver;
    }

    public TeammatePage manageProfile() {
        // Page encapsulation to manage profile functionality
        return new TeammatePage(driver);
    }
    public TeammatePage clickTeammate() {
        driver.findElement(SettingsBy).click();
        driver.findElement(CompanyBY).click();
        driver.findElement(teammateBy).click();
        driver.findElement(inviteBy).click();
        return new TeammatePage(driver);
    }

    
}
