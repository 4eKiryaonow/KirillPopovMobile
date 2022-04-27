package com.epam.tc.hw2.pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class RegistrationPageObject extends NativePageObject {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_email")
    private WebElement emailRegField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_username")
    private WebElement usernameRegField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_password")
    private WebElement passwordRegField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_confirm_password")
    private WebElement passwordRegConfirmField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value=\"Register new account\"]")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "register_new_account_button")
    private WebElement regNewAccountBtn;

    public RegistrationPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public LoginPageObject registerNewAccount(String email, String username, String password) {

        emailRegField.sendKeys(email);
        usernameRegField.sendKeys(username);
        passwordRegField.sendKeys(password);
        passwordRegConfirmField.sendKeys(password);
        driver.hideKeyboard();
        regNewAccountBtn.click();
        return new LoginPageObject(driver);
    }
}
