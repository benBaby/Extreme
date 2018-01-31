package com.extreme.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.extreme.R;
import com.extreme.ui.base.BaseActivity;
import com.extreme.ui.base.BaseFragment;
import com.extreme.ui.event.EventFragment;
import com.extreme.ui.expand.ExpandFragment;
import com.extreme.ui.mainPage.MainPageFragmnet;

public class MainActivity extends BaseActivity implements MainContract.MainView, RadioGroup.OnCheckedChangeListener {

    private TextView centerTitle;   //标题
    private static final int HOME = 1;
    private BaseFragment showFragment;
    private FragmentManager mFragmentManager;
    private RadioGroup radioGroup;
    private DrawerLayout drawerlayout;

    private MainContract.MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        new MainPresenter(this);
        initFragmnet();
    }

    @Override
    public void setPresenter(MainContract.MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void bindView() {
        //set title
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        centerTitle = findViewById(R.id.centerTitle);
        centerTitle.setText(R.string.main_page);
        setSupportActionBar(toolbar);

        radioGroup = findViewById(R.id.tab_radiogroup);
        radioGroup.setOnCheckedChangeListener(this);

        drawerlayout = findViewById(R.id.drawerlayout);
        drawerlayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    /** 初始化fragment */
    public void initFragmnet() {
        mFragmentManager = getSupportFragmentManager();
        MainPageFragmnet mainPageFragmnet = new MainPageFragmnet();
        mFragmentManager.beginTransaction()
                .add(R.id.show_fragmnet, mainPageFragmnet, String.valueOf(HOME))
                .commitAllowingStateLoss();
        showFragment = mainPageFragmnet;
        radioGroup.check(R.id.tab_main_page);
        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tab_main_page:
                centerTitle.setText(R.string.main_page);
                replaceFragment(R.id.tab_main_page);
                drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                break;

            case  R.id.tab_action:
                centerTitle.setText(R.string.action);
                replaceFragment(R.id.tab_action);
                drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                break;

            case R.id.tab_expand:
                centerTitle.setText(R.string.expand);
                replaceFragment(R.id.tab_expand);
                drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                break;
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onBackPressed() {
        if (showFragment instanceof MainPageFragmnet) {
            super.onBackPressed();
        } else {
            replaceFragment(HOME);
            radioGroup.check(R.id.tab_main_page);
        }
    }

    @Override
    public void replaceFragment(int tag) {
        Fragment fragment = mFragmentManager.findFragmentByTag(String.valueOf(tag));
        if (fragment != null) {
            mFragmentManager.beginTransaction()
                    .show(fragment)
                    .hide(showFragment)
                    .commitAllowingStateLoss();
        } else {
            fragment = fragmentFactory(tag);
            if (fragment == null) {
                return;
            }
            mFragmentManager.beginTransaction()
                    .add(R.id.show_fragmnet, fragment, String.valueOf(tag))
                    .hide(showFragment)
                    .commit();
        }
        showFragment = (BaseFragment) fragment;
    }

    @Override
    public Fragment fragmentFactory(int tag) {
        Fragment fragment = null;
        switch (tag) {
            case R.id.tab_main_page:
                fragment = new MainPageFragmnet();
                break;

            case R.id.tab_action:
                fragment = new EventFragment();
                break;

            case R.id.tab_expand:
                fragment = new ExpandFragment();
                break;

                default:

                    break;
        }
        return fragment;
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
    }
}
