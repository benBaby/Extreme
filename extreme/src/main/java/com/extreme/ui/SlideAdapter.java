package com.extreme.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.extreme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Instructions :
 * Created by ZZ on 2018/3/29.
 */

public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SlideViewHolder> {

    private Context context;
    private List<String> list = null;
    private SlideAdapterListener listener;

    SlideAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        list.add(context.getString(R.string.scan));  //扫描
        list.add(context.getString(R.string.rli));    //日历
        list.add(context.getString(R.string.video)); //视频
        list.add(context.getString(R.string.map));    //地图
    }

    @Override
    public SlideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new SlideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SlideViewHolder holder, final int position) {
            holder.label.setText(list.get(position));
            holder.label.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(list.get(position), position);
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SlideViewHolder extends RecyclerView.ViewHolder {
        TextView label;
        SlideViewHolder(View itemView) {
            super(itemView);
            label = itemView.findViewById(android.R.id.text1);
        }
    }

    interface SlideAdapterListener {
        void OnItemClick(String label, int postion);
    }

    public void setSlideAdapterListener(SlideAdapterListener listener) {
        this.listener = listener;
    }
}
