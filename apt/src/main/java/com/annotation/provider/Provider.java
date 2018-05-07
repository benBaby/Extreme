package com.annotation.provider;

import android.content.Context;
import android.view.View;

/**
 * Instructions :
 * Created by ZZ on 2018/5/4.
 */

public interface Provider {
    Context getContext(Object surce);

    View findView(Object surce, int id);
}
