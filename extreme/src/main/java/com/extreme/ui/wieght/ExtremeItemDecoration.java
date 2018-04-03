package com.extreme.ui.wieght;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;

/**
 * Instructions :  RecyclerView 线
 * Created by ZZ on 2018/3/28.
 */

public class ExtremeItemDecoration extends DividerItemDecoration {
    private static final String TAG = ExtremeItemDecoration.class.getSimpleName();

    /**
     * Creates a divider {@link RecyclerView.ItemDecoration} that can be used with a
     * {@link LinearLayoutManager}.
     *
     * @param context     Current context, it will be used to access resources.
     * @param orientation Divider orientation. Should be {@link #HORIZONTAL} or {@link #VERTICAL}.
     */
    public ExtremeItemDecoration(Context context, int orientation) {
        super(context, orientation);
    }

}
