package com.epam.tc.hw2.pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class BudgetActivityPageObject extends NativePageObject {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@label='Budget']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    private WebElement pageTitle;

    public BudgetActivityPageObject(AppiumDriver appiumDriver) {

        super(appiumDriver);
    }

    public String getTitle() {

        return pageTitle.getText();
    }
}
