package com.epam.tc.hw2.pageObjects.webApp;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPageObject extends WebPageObject {

    @FindBy(css = "div[data-hveid] > [class*='mnr-c']")
    private List<WebElement> searchResultsTitles;

    public SearchResultPageObject(AppiumDriver appiumDriver) {

        super(appiumDriver);
    }

    public List<String> getSearchResultsTitles() {

        return searchResultsTitles.stream()
                                  .map(WebElement::getText)
                                  .collect(Collectors.toList());
    }
}
