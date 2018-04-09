package com.extreme.ui.wieght.combinationUI;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.extreme.R;

/**
 * 组合控件  输入框
 * **************************************************************************************************
 *    | 标题 :   输入框 |
 * **************************************************************************************************
 * Created by ZZ on 2018/2/2.
 */

public class InputLayout extends LinearLayout{

    public InputLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_input, null, false);
        TextView title = view.findViewById(R.id.input_title);
        EditText content = view.findViewById(R.id.input_content);
        LinearLayout layout = view.findViewById(R.id.input_layout);
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.InputLayout);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
           int attr = typedArray.getIndex(i);
           switch (attr) {
               case R.styleable.InputLayout_inputTitleSize :  //设置标题大小

                   break;

               case R.styleable.InputLayout_inputTitle:    //设置标题文字
                   String titleName = typedArray.getString(attr);
                   if (TextUtils.isEmpty(titleName)) {
                       title.setVisibility(View.GONE);
                   } else {
                       title.setVisibility(View.VISIBLE);
                       title.setText(titleName);
                   }
                   break;

               case R.styleable.InputLayout_inputBackgroundColor:   //背景颜色
                   int color = typedArray.getColor(attr, Color.WHITE);
                   layout.setBackgroundColor(color);
           }
        }

        typedArray.recycle();
    }


}
