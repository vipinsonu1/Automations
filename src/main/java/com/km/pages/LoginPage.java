package com.km.pages;

import com.km.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id = "email-input-field")
    WebElement email;

    @FindBy(xpath = "//input[@class='input']")
    WebElement passwoard;

    @FindBy(xpath = "//*[@id='root']/div/div[2]/div[1]/div/div[2]/div/div/div/div/div[1]/h1")
    WebElement titleText;

    @FindBy(id = "login-button")
    WebElement login;

    @FindBy(xpath = "//div[@id='application-list-main-container']//div[1]")
    WebElement appsList;

    @FindBy(xpath = "//h1[@class='login-signup-heading text-center']")
    WebElement kmLoginPage;


    public LoginPage() {

        PageFactory.initElements(driver, this);
    }


   /* public void setUserName(String strUserName){

        email.sendKeys(strUserName);
    }
*/

    /* public void setPassword(String strPassword){

         passwoard.sendKeys(strPassword);

     }
 */
    public void getAppList() {

        appsList.click();

    }


    public void clickLogin() {

        login.click();

    }


    public String getLoginTitle() {

        return titleText.getText();

    }

    public boolean validateLoginPage() {
        return kmLoginPage.isDisplayed();
    }

    public DashboardPage loginToDashboard(String strUserName, String strPassword) {

        email.sendKeys(strUserName);
        passwoard.sendKeys(strPassword);

        clickLogin();
        getAppList();
        return new DashboardPage();
    }
}
