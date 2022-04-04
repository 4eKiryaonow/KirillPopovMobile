package com.epam.tc.hw2.pageObjects;

import com.epam.tc.hw2.pageObjects.nativeApp.LoginPageObject;
import com.epam.tc.hw2.pageObjects.webApp.WebPageObject;
import com.epam.tc.hw2.setup.IPageObject;
import io.appium.java_client.AppiumDriver;

public class PageObject implements IPageObject {

    AppiumDriver driver;
    Object somePageObject; // it should be set of webApp page or EPAM Test App WebElements

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        driver = appiumDriver;
        System.out.println("Current app type: " + appType);
        switch (appType) {
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new LoginPageObject(appiumDriver);
                break;
            default:
                throw new Exception("Can't create a page object for " + appType);
        }
    }

    @Override
    public Object getObjectInstance() {

        return somePageObject;
    }
}
