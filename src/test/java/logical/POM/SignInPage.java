package logical.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    protected WebDriver driver;

    private By emailBy = By.id("email-input-field");
    private By passwordBy = By.xpath("//input[@type='password']");
    private By loginBy = By.id("login-button");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    /*
     * Login as valid user
     *
     * @param userName
     * @param password
     * @return HomePage object
     */
    public TeammatePage loginValidUser(String email, String password) {
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
        return new TeammatePage(driver);
    }
}