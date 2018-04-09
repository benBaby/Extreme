package com.extreme.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.extreme.R;
import com.extreme.ui.base.BaseActivity;

/**
 * 登录
 * Created by ZZ on 2018/1/26.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View, View.OnClickListener {

    private LoginContract.Presenter presenter;
    private EditText etusername, etpasswords;
    private Button btnlogin;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_lagin);
        super.onCreate(savedInstanceState);
        setToolbar(R.string.login);
        new LoginPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onStart();
    }

    @Override
    protected void bindView() {
        btnlogin = findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(this);
        etpasswords = findViewById(R.id.et_passwords);
        etusername = findViewById(R.id.et_username);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
         if (viewId == btnlogin.getId()) {
             presenter.login();
         }
    }

    @Override
    public void setLoginBtnState(boolean flag) {
        btnlogin.setClickable(flag);
    }

    @Override
    public void setVerificationCodeBtnStte(boolean flag) {

    }
    @Override
    public void loginFail() {
        etpasswords.getText().clear();
    }

    @Override
    public void loginSuccess() {

    }
}
