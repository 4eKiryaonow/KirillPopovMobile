package com.epam.tc.hw2.utils;

public class TestDataProvider {

    //for native test
    public static final String EMAIL = PropertiesReader.getProperty("email");
    public static final String PASSWORD = PropertiesReader.getProperty("password");
    public static final String USERNAME = PropertiesReader.getProperty("username");
    public static final String TITLE_BUDGET_ACTIVITY_PAGE = PropertiesReader.getProperty("titleBudgetActivityPage");

    //for web test
    public static final String URL = PropertiesReader.getProperty("url");
    public static final String QUERY = PropertiesReader.getProperty("query");
}
