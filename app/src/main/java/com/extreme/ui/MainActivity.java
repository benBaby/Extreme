package com.extreme.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.extreme.R;
import com.extreme.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView centerTitle;   //标题

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void bindView() {
        //set title
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        centerTitle = findViewById(R.id.centerTitle);
        centerTitle.setText(R.string.main_page);
        setSupportActionBar(toolbar);

        RadioGroup radioGroup = findViewById(R.id.tab_radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tab_main_page:
                centerTitle.setText(R.string.main_page);
                break;

            case  R.id.tab_action:
                centerTitle.setText(R.string.action);
                break;

            case R.id.tab_set:
                centerTitle.setText(R.string.set);
                break;
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onRefresh() {
        super.onRefresh();
    }
}
