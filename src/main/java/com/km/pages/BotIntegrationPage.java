package com.km.pages;

import com.km.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class BotIntegrationPage  extends TestBase {



    public BotIntegrationPage() {
        PageFactory.initElements(driver, this);
    }

}
