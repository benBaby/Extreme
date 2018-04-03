package com.extreme.tools;

/**
 * Created by ZZ on 2018/1/29.
 */

public class StringHelper {

    public static boolean isEmtry(String... message) {
        return message == null || message.equals("") || message.equals("null");
    }
}
