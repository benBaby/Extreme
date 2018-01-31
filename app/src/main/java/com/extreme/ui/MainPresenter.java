package com.extreme.ui;

/**
 * Created by ZZ on 2018/1/30.
 */

public class MainPresenter implements MainContract.MainPresenter {

    private MainContract.MainView mainView;

    MainPresenter(MainContract.MainView mianView) {
        this.mainView = mianView;
        mainView.setPresenter(this);
    }

    @Override
    public void onStart() {
    }
}
