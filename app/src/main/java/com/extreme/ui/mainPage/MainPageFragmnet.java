package com.extreme.ui.mainPage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        //set title
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView centerTitle = view.findViewById(R.id.centerTitle);
        centerTitle.setText(R.string.main_page);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        SwipeRefreshLayout swiperefreshlayout = view.findViewById(R.id.swiperefreshlayout);

        swiperefreshlayout.setOnRefreshListener(this);
        swiperefreshlayout.setColorSchemeColors(getResources().getColor(R.color.colorFontBlue));
        swiperefreshlayout.setRefreshing(false);
        swiperefreshlayout.setEnabled(false);

        RecyclerView recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(context));
        /** 测试代码 */
        recyclerview.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);
                return new TextViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextViewHolder)holder).textView.setText("第 " + position  + " 行");
            }

            @Override
            public int getItemCount() {
                return 20;
            }

            class TextViewHolder extends RecyclerView.ViewHolder {
                TextView textView;
                TextViewHolder(View itemView) {
                    super(itemView);
                    textView = itemView.findViewById(android.R.id.text1);
                }
            }
        });

        /** 测试代码 */
    }



    @Override
    protected void loadData() {

    }

    @Override
    public void onRefresh() {

    }
}
