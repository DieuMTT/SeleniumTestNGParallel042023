package com.dieutester.constants;

import com.dieutester.helpers.PropertiesHelper;

public class ConfigData {
    static {
        PropertiesHelper.loadAllFiles();
    }

    public static String URL = PropertiesHelper.getValue("url");
    public static String EMAIL = PropertiesHelper.getValue("email");
    public static String PASSWORD = PropertiesHelper.getValue("password");
    public static String CATEGORY_NAME = PropertiesHelper.getValue("category_name");
    public static String PRODUCT_NAME = PropertiesHelper.getValue("url");

}
