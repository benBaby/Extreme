package com.annotation;

import com.annotation.provider.Provider;

/**
 * Instructions :
 * Created by ZZ on 2018/5/4.
 */

public interface Finder<T> {
    void inject(T host, Object surce, Provider provider);
}
