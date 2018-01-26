package com.extreme.global;

import android.support.v4.app.FragmentActivity;

import java.util.Stack;

/**
 * activity 栈管理
 * Created by ZZ on 2018/1/26.
 */

public class ActivityStack {

    // Stack 管理activity栈的生命周期
    private static Stack<FragmentActivity> sActivityStack;

    private static class ActivityStackHolder {
        private static final ActivityStack INSTANCE = new ActivityStack();
    }

    public static ActivityStack newInstance() {
        return ActivityStackHolder.INSTANCE;
    }

    /**  将actviivity 按压到Stack 的顶部 */
    public void pushActivity(FragmentActivity activity) {
        if (sActivityStack == null) {
            sActivityStack = new Stack<>();
        }
        sActivityStack.push(activity);
    }

    /**  将actviivity 从 Stack 的移除 */
    public void popActivity(FragmentActivity activity) {
        if (sActivityStack != null) {
          sActivityStack.remove(activity);
        }
    }

    /**  activity finish */
    private void finishActivity(FragmentActivity activity) {
        if (activity != null) {
            activity.finish();
        }
        popActivity(activity);
    }

    /** 移除所有的activity */
    public void clearAllActivity() {
        for (int i = sActivityStack.size() - 1; i >= 0; i--) {
            FragmentActivity activity = sActivityStack.pop();
            finishActivity(activity);
        }
    }



    /** 回退到指定界面 */

}
