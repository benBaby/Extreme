package com.extreme.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.extreme.R;
import com.extreme.customListener.ShowRefreshListener;
import com.extreme.customListener.ShowRefreshManager;
import com.extreme.global.ActivityStack;
import com.extreme.ui.login.LoginActivity;

/**
 * 基础activity
 * Created by ZZ on 2018/1/26.
 */

public abstract class BaseActivity extends AppCompatActivity implements ShowRefreshListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将当前的activity 添加到ActivityStack管理中
        ActivityStack.newInstance().pushActivity(this);
        //主要用于界面数据传递，和刷新
        ShowRefreshManager.newInstance().registered(this);
        init();
    }

    /**
     *  继承BaseActivity 后 覆写onCreate() 方法， 然后实现抽象方法 bindView() 和 loadData() 即可
     * */
    private void init() {
        bindView();
        loadData();
    }

    //绑定控件
    protected abstract void bindView();

    //加载数据
    protected abstract void loadData();

    /**
     * 设置Toolbar
     * @param CenterTitleResId 中间标题
     * */
    protected void setToolbar(int CenterTitleResId) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView centerTitle = findViewById(R.id.centerTitle);
        centerTitle.setText(CenterTitleResId);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //将当前的activity 移除 ActivityStack管理中
        ActivityStack.newInstance().finishActivity(this);
        ShowRefreshManager.newInstance().unRegisterListener(this);
    }

/**----- 以上为acyivity 生命周期   一下为接口接口实现类-----------*/

    @Override
    public void onRefresh() {
    }

    @Override
    public void onRefresh(Object object) {

    }

    /** 跳转到登录界面 */
    protected void toLoginActivity() {
        Intent mIntent = new Intent();
        mIntent.setClass(this, LoginActivity.class);
        startActivity(mIntent);
    }
}
