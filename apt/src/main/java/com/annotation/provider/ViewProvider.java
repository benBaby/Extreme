package com.annotation.provider;

import android.content.Context;
import android.view.View;

/**
 * Instructions :
 * Created by ZZ on 2018/5/4.
 */

public class ViewProvider implements Provider {
    @Override
    public Context getContext(Object surce) {
        return ((View)surce).getContext();
    }

    @Override
    public View findView(Object surce, int id) {
        return ((View)surce).findViewById(id);
    }
}
