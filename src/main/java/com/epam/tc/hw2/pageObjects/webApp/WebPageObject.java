package com.epam.tc.hw2.pageObjects.webApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {

    AppiumDriver driver;
    @FindBy(css = "input[type='search']")
    private WebElement searchField;

    public WebPageObject(AppiumDriver appiumDriver) {
        driver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public WebPageObject openUrl(String url) {

        driver.get(url);
        return this;
    }

    public SearchResultPageObject searchRequest(String query) {

        searchField.sendKeys(query, Keys.ENTER);
        return new SearchResultPageObject(driver);
    }
}
