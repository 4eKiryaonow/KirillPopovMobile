package com.epam.tc.hw2.pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends NativePageObject {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "login_email")
    private WebElement usernameAuthField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "login_pwd")
    private WebElement passwordAuthFiled;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "register_button")
    private WebElement registerNewAccountBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Sign In']")
    @AndroidFindBy(id = APP_PACKAGE_NAME + "email_sign_in_button")
    private WebElement signInBtn;

    public LoginPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public BudgetActivityPageObject login(String email, String password) {

        usernameAuthField.sendKeys(email);
        passwordAuthFiled.sendKeys(password);
        signInBtn.click();
        return new BudgetActivityPageObject(driver);
    }

    public RegistrationPageObject openRegistrationPage() {

        registerNewAccountBtn.click();
        return new RegistrationPageObject(driver);
    }
}
