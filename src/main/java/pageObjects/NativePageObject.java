package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;
    
    @AndroidFindBy(id ="platkovsky.alexey.epamtestapp:id/login_email")
    WebElement usernameAuthField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement passwordAuthFiled;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerNewAccountBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailRegField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement usernameRegField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordRegField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement passwordRegConfirmField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    WebElement pageTitle;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
