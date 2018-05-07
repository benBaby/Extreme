package com.annotation;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.annotation.provider.ActivityProvider;
import com.annotation.provider.Provider;
import com.annotation.provider.ViewProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Instructions :
 * Created by ZZ on 2018/5/4.
 */

public class ViewFinder {

    private static final ActivityProvider PROVIDER_ACTIVITY = new ActivityProvider();
    private static final ViewProvider PROVIDER_VIEW = new ViewProvider();

    private static final Map<String, Finder> FINDER_MAP = new HashMap<>();

    public static void inject(AppCompatActivity activity) {
        inject(activity, activity, PROVIDER_ACTIVITY);
    }

    public static void inject(View view) {
        inject(view, view);
    }

    public static void inject(Object host, View view) {
        //for fragment
        inject(host, view, PROVIDER_VIEW);
    }

    public static void inject(Object host, Object surce, Provider provider) {
        String className = host.getClass().getName();
        try {
            Finder finder = FINDER_MAP.get(className);
            if (finder == null) {
                Class<?> finderClass = Class.forName(className + "$$Finder");
                finder = (Finder) finderClass.newInstance();
                FINDER_MAP.put(className, finder);
            }
            finder.inject(host, surce, provider);
        } catch (Exception e) {
            throw new RuntimeException("Unable to inject for " + className, e);
        }
    }
}
