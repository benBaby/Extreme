package com.extreme.ui.login;

import com.extreme.ui.base.BasePresenter;
import com.extreme.ui.base.BaseView;

/**
 *  登录合约类  ----  声明界面更新和Presenter处理逻辑的方法
 * Created by ZZ on 2018/1/29.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void setLoginBtnState(boolean b);
        void setVerificationCodeBtnStte(boolean b);
        void clearInput();
        void loginFail();
        void loginSuccess();
        void showProgress();
    }

    interface Presenter extends BasePresenter {
        void getVerificationCode();    // 验证码
        void login();  //登录

    }
}
