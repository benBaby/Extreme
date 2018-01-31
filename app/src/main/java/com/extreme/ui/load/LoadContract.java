package com.extreme.ui.load;

import com.extreme.data.model.User;
import com.extreme.ui.base.BasePresenter;
import com.extreme.ui.base.BaseView;

/**
 * google官网MVP模式框架
 *   加载页合约
 * Created by ZZ on 2018/1/31.
 */

public interface LoadContract {

    interface LoadView extends BaseView<LoadPresenter> {
        void showDialog();         //显示提示
        void toMmainActivity();    //跳转到主页
    }

    interface LoadPresenter extends BasePresenter {
        boolean getLoginState();   //获取登录状态
        User getUsernfo();          //获取用户信息
        void getVersionCode();     //获取版本信息
    }

}
