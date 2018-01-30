package com.extreme.ui.mainPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.extreme.R;
import com.extreme.ui.base.BaseFragment;

/**
 * Created by ZZ on 2018/1/30.
 */

public class MainPageFragmnet extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragmnet_main_page;
    }

    @Override
    protected void bandView(View view) {
        RecyclerView recyclerview = view.findViewById(R.id.recyclerview);
    }

    @Override
    protected void loadData() {

    }
}
