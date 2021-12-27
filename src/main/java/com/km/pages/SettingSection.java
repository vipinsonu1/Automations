package com.km.pages;

import com.km.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingSection extends TestBase {
    @FindBy(xpath = "//a[@data-tip='Settings']")
    WebElement settingLink;
    @FindBy(xpath = "//p[@class='SettingsSidebarStyles__SettingsTitle-a5llgw-6 bIgFgR']")
    WebElement settings;

    @FindBy(xpath = "//a[normalize-space()='Notification Preferences']")
    WebElement notificationPreferences;
    public SettingSection() {
        PageFactory.initElements(driver, this);
    }
    public String verifySettings() { return settings.getText(); }
    public void clickonSetting(){ settingLink.click();
    }
}
