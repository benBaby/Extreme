package com.extreme.ui.load;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.extreme.data.model.User;
import com.extreme.ui.MainActivity;
import com.extreme.ui.base.BaseActivity;

/**
 * 登录界面
 * Created by ZZ on 2018/1/31.
 */

public class LoadActivity extends BaseActivity implements LoadContract.LoadView {

    private LoadContract.LoadPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        new LoadPresenter(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setPresenter(LoadContract.LoadPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void bindView() {

    }

    @Override
    protected void loadData() {
        boolean isLogin;
        User user;
        isLogin = presenter.getLoginState();
        user = presenter.getUsernfo();
        if (isLogin && user != null) {
            if (presenter.getVersionCode().equals("1")) {
                toMmainActivity();
            }
        } else {
            toLoginActivity();
            finish();
        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void toMmainActivity() {
        Intent mIntent = new Intent(this, MainActivity.class);
        startActivity(mIntent);
        finish();
    }
}
