package com.epam.tc.hw2.pageObjects;

import com.epam.tc.hw2.pageObjects.nativeApp.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import com.epam.tc.hw2.pageObjects.nativeApp.NativePageObject;
import com.epam.tc.hw2.pageObjects.webApp.WebPageObject;
import com.epam.tc.hw2.setup.IPageObject;

public class PageObject implements IPageObject {

    AppiumDriver driver;
    Object somePageObject; // it should be set of webApp page or EPAM Test App WebElements

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        driver = appiumDriver;
        System.out.println("Current app type: " + appType);
        switch (appType) {
            case "webApp":
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
