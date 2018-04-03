package com.extreme.global;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Instructions :
 * Created by ZZ on 2018/4/3.
 */

public class SharedPreferencesHelper {

    private static SharedPreferences mShared = null;
    private static SharedPreferences.Editor mEditor = null;
    private static String SHARE_NAME = "Extreme_shared";

    private static String ISLOGIN = "isLogin";

    private static SharedPreferences getShared(Context context) {
        if (context == null) {
            context = ExtremeApp.getExtremeAppContext();
        }
        if (mShared == null) {
            mShared = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        }
        return mShared;
    }

    private static SharedPreferences.Editor getEditor(Context context) {
       if (context == null) {
           context = new ExtremeApp().getApplicationContext();
       }
        getShared(context);
       if (mEditor == null) {
           mEditor = getShared(context).edit();
       }
        return mEditor;
    }

    public static void setLoginState(Context context, boolean flag) {
        getEditor(context).putBoolean(ISLOGIN, flag);
        getEditor(context).apply();
    }

    public static boolean getLoginState(Context context) {
      return getShared(context).getBoolean(ISLOGIN, true);
    }

    public static void setInit(Context context) {
        getEditor(context).putString("initSharedPreference", "initSharedPreference");
        getEditor(context).apply();
    }
}
