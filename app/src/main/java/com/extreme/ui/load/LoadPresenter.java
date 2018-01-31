package com.extreme.ui.load;


import android.util.Log;

import com.extreme.data.model.User;

/**
 * 加载页逻辑实现类
 * Created by ZZ on 2018/1/31.
 */

public class LoadPresenter implements LoadContract.LoadPresenter {
    private static final String TAG = LoadPresenter.class.getSimpleName();

    private LoadContract.LoadView loadView;

    LoadPresenter(LoadContract.LoadView loadView) {
        this.loadView = loadView;
        loadView.setPresenter(this);
    }

    @Override
    public void onStart() {

    }

    @Override
    public boolean getLoginState() {
        Log.i(TAG, "== getLoginState ==");
        return false;
    }

    @Override
    public User getUsernfo() {
        return null;
    }

    @Override
    public void getVersionCode() {

    }
}
