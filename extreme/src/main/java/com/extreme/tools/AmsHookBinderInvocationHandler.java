package com.extreme.tools;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;

import com.extreme.global.SharedPreferencesHelper;
import com.extreme.ui.login.LoginActivity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Instructions :
 * Created by ZZ on 2018/4/2.
 */

public class AmsHookBinderInvocationHandler implements InvocationHandler {

    private static final String TAG = "HookHandler";

    private Object mBase;

    AmsHookBinderInvocationHandler(Object mBase) {
        this.mBase = mBase;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.i(TAG, "method :" + method.getName() + "\ncall with args : " + Arrays.toString(args));
        if ("startActivity".equals(method.getName())) {
            Intent mIntent;
            int index = 0;
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Intent) {
                    index = i;
                    break;
                }
            }
            //在startActivity 时 判断是否登录，没有的话跳转到登录接口
            if (!SharedPreferencesHelper.getLoginState(null)) {
                mIntent = (Intent) args[index];
                String targetPackage = "com.myapplicationextreme";
                ComponentName componentName = new ComponentName(targetPackage, LoginActivity.class.getName());
                mIntent.setComponent(componentName);
                args[index] = mIntent;
            }
        }
        return method.invoke(mBase, args);
    }
}
