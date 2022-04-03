package com.epam.tc.hw2.utilities;

public class TestDataProvider {

    public static final String EMAIL = PropertiesReader.getProperty("email");
    public static final String PASSWORD = PropertiesReader.getProperty("password");
    public static final String USERNAME =  PropertiesReader.getProperty("username");
    public static final String TITLE_BUDGET_ACTIVITY_PAGE = PropertiesReader.getProperty("titleBudgetActivityPage");
}
