package com.extreme.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment 基础类
 * Created by ZZ on 2018/1/30.
 */

public abstract class BaseFragment extends Fragment {

    /** 加载布局文件 */
    protected abstract int getLayoutId();
    /** 绑定UI */
    protected abstract void bandView(View view);
    /** 加载数据 */
    protected abstract void loadData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        bandView(view);
        loadData();
        return view;
    }


}
