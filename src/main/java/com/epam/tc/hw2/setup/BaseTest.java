package com.epam.tc.hw2.setup;

import com.epam.tc.hw2.pageObjects.PageObject;
import com.sun.javafx.binding.StringFormatter;
import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    private static PageObject po;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPageObject() {
        return po;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName", "app", "appPackage",
        "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId
    ) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId);
        setPageObject(appType, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String udid, String browserName, String app,
                                 String appPackage, String appActivity, String bundleId) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);

        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        // Capabilities for test of Android native app on EPAM Mobile Cloud
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        // Capabilities for test of iOS native app on EPAM Mobile Cloud
        capabilities.setCapability("bindleId", bundleId);

        if (platformName.equals("iOS")) {
            capabilities.setCapability("automationName", "XCUITest");
        }

        String s = "+ctebRyzdAfsJ9I1OaYwaMQNkjW6XtV7i9NOsRnAuqA1P34fltaD8Vpk69tFOOj5BiAkKDxmoR+pbmSqGmLFcvrDn0WS+ec5Y5dn6i5e8y8gejT3XO1/yhLxz6KK+jKVyacfTkycdQEUXfpRJjzJ5rPsDkWEXo824HXB+LEN90Np/X1H6VdItQ6KBDrShgyh5WSAoJGlPzyFKk51fSxiVnm1X9BKHCaOp6EdzYGkgqQ/e/QYdOQubxkeln4Lp4vPoUxWIZItcQBathVod5V9uB10puVmhI3eF6eeqHyCRoIyTRZJSjBsbmGPkK3vGMNeBY2sbjOdZQaL4RAtNuisNmXzp3UcTohN19ViWijitd0kI02k6vwZbIkoAFRZfZwvLlXwPjZ6vqaDR3HevEC6GcZvVVf00RxTtGqj5xdYYOXwb/JqPgfbXdSuxbpkatHsnnLZdOtKzw2JgH/eS8Z154wwygRJUnbD5NuIXd5TNmfJu8QOEKPlNMIxerQHpWYyl3yBgNAm8/McM3P9Zp27IFLvt/AhB8QW5WNzIzJ2Mle7laiKE8hLLPZyFuleeBKKuYohsHj8XNZXUQGaURUSXy6BOFLsV/NtulKdbn2J9Yi2urafMxCjL0NwtSFeAYmgqr2Rl0rt6ubBNBZR+8ENkvogS7B6I0qhdGOK2aHvKlmTuiKQbGdu/dTALhY5QEKECgdFE1Idy6fah2P6IeS4dfqrUdyXgjtSI7o1n1WHmYZ67z54jGdIwp5cZifqRjJxLfALUtVpHJeFXv8n63U1R/Hhc++bl2Zo16y899Q2kIBTNQBasLGlcjdKR4xeB0QY6HKvpw68smxHu/+u/ym1kHQAm9S/9peB+gBqjSw42X+Saea18xIUvqvluZeQ2Bl8aGMRTp+Nx1PXODkIvLNY3oo";


        try {
            appiumDriver = new AppiumDriver(
                new URL("https://EPM-TSTF:" +
                    URLEncoder.encode(s, StandardCharsets.UTF_8.toString()) +
                    "@mobilecloud.epam.com/wd/hub") , capabilities);
        } catch (MalformedURLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }
}
