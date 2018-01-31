package com.extreme.ui.mainPage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.extreme.R;
import com.extreme.ui.base.BaseFragment;

/**
 * Created by ZZ on 2018/1/30.
 */

public class MainPageFragmnet extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragmnet_main_page;
    }

    @Override
    protected void bandView(View view) {
        SwipeRefreshLayout swiperefreshlayout = view.findViewById(R.id.swiperefreshlayout);

        swiperefreshlayout.setOnRefreshListener(this);
        swiperefreshlayout.setColorSchemeColors(getResources().getColor(R.color.colorFontBlue),
                getResources().getColor(R.color.colorFontGray));
        swiperefreshlayout.setRefreshing(true);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onRefresh() {

    }
}
