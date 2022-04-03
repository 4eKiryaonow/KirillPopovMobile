package com.epam.tc.hw2.pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RegistrationPageObject extends NativePageObject {

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_email")
    private WebElement emailRegField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_username")
    private WebElement usernameRegField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_password")
    private WebElement passwordRegField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_confirm_password")
    private WebElement passwordRegConfirmField;

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
