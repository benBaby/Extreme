package com.extreme.ui.login;

/**
 * @see LoginContract.Presenter
 * Created by ZZ on 2018/1/29.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View loginView;

    LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
        loginView.setPresenter(this);
    }

    @Override
    public void onstart() {
        loginView.setLoginBtnState(false);
        loginView.setVerificationCodeBtnStte(false);
    }

    @Override
    public void login() {

    }

    @Override
    public void getVerificationCode() {

    }
}
