package com.annotation.provider;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Instructions :
 * Created by ZZ on 2018/5/4.
 */

public class ActivityProvider implements Provider {

    @Override
    public Context getContext(Object surce) {
        return ((AppCompatActivity)surce);
    }

    @Override
    public View findView(Object surce, int id) {
        return ((AppCompatActivity)surce).findViewById(id);
    }
}
