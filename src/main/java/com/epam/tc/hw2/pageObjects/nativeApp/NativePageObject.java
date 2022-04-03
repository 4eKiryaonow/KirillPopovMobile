package com.epam.tc.hw2.pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    public static final String APP_PACKAGE_NAME = "platkovsky.alexey.epamtestapp:id/";
    AppiumDriver driver;

    public NativePageObject(AppiumDriver appiumDriver) {
        driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
