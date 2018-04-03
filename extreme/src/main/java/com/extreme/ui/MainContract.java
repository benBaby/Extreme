package com.extreme.ui;

import android.support.v4.app.Fragment;

import com.extreme.ui.base.BasePresenter;
import com.extreme.ui.base.BaseView;

/**
 * mainActivity 合约类
 * Created by ZZ on 2018/1/30.
 */

public interface MainContract {

    interface MainView extends BaseView<MainPresenter> {
        void initFragmnet();                    //初始化fragment
        void replaceFragment(int tag);         //切换fragmnet
        Fragment fragmentFactory(int tag);      // fragmnet工厂
    }

    interface MainPresenter extends BasePresenter {

    }
}
