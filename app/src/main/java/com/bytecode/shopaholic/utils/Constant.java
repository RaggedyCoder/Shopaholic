package com.bytecode.shopaholic.utils;

import java.util.HashMap;

/**
 * Created by ultimate on 5/8/2015.
 */
public class Constant {

    public static String url = "https://api.parse.com/1";
    public static String url_login = url + "/login?";
    public static String signUpUrl = url + "/users";
    public static String resetUrl = url + "/requestPasswordReset";
    public static String productUrl = url + "/classes/Product?";


    public static HashMap<String, String> headers = new HashMap<String, String>();

    static {
        headers.put("X-Parse-Application-Id", "R6kBbmhFNsPv44ekZbLlC6hq7JZ7b4fWT5G3H3GN");
        headers.put("Content-Type", "application/json");
        headers.put("X-Parse-REST-API-Key", "QHh6SwA97ioIo8ZkmEczrpFr8jZB5G5rYybrlbpO");

    }


}
