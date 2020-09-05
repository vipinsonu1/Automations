package com.km.pages;

import com.km.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConversationsPage extends TestBase {
    WebDriver driver;

    @FindBy(xpath="//a[@class='nav-link conversation-menu active']//*[local-name()='svg']")
    WebElement conversationsActive;
}
