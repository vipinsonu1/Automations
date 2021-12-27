package com.km.pages;

import com.km.pageutility.TeamMate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeammateSectionPage {
    private WebDriver driver;
           private By email=By.xpath("//input[@id='email-field']");
           private By role=By.xpath("//span[normalize-space()='Admin']");
           private By company=By.xpath("//h2[normalize-space()='COMPANY']");
           private By team=By.xpath("//a[@href='/settings/team']");
           private By invite=By.xpath("//button[@id='invite']");
           private  By addTeammate=By.xpath("//button[.='Add teammate']");
           private  By successMsg=By.cssSelector("#toast-notification-text");
          // //div[normalize-space()='vipin+adkm14042021@kommunicate.io']/parent::div/parent::div/parent::td/following-sibling::td/div/div[text()='Edit']
           public TeammateSectionPage(WebDriver driver){
              this.driver =driver;
           }

    public void clickCompany(){ driver.findElement(company).click();}
    public void clickTeam(){ driver.findElement(team).click();}

    public  String fillEmail(TeamMate teamMate){
        driver.findElement(email).sendKeys(teamMate.getEmail());
        driver.findElement(role).click();
        driver.findElement(addTeammate).click();
        return driver.findElement(successMsg).getText();
    }
    public void sendTeamInvite(TeamMate teamMate){
               clickCompany();
               clickTeam();
               fillEmail(teamMate);

    }
public void updateRole(TeamMate teamMate, String inviteEmail){
    clickCompany();
    clickTeam();
    driver.findElement(By.xpath("//div[normalize-space()='"+inviteEmail+"']/parent::div/parent::div/parent::td/following-sibling::td/div/div[text()='Edit']")).click();
    fillEmail(teamMate);

           }

}

