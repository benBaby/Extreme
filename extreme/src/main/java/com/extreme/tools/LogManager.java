package com.extreme.tools;

import android.text.TextUtils;

/**
 * Instructions : Logger 日志管理
 * Created by ZZ on 2018/3/27.
 */

public class LogManager {


    private static String generateTag(StackTraceElement element) {
        String TAG = "%s.%s(L:%d)";
        String className = element.getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        TAG = String.format(TAG, className, element.getMethodName(), element.getLineNumber());
        TAG = TextUtils.isEmpty(TAG) ? "" : TAG;
        return TAG;
    }


}
