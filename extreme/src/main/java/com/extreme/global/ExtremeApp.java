package com.extreme.global;

import android.app.Application;

/**
 * app全局环境变量
 * Created by ZZ on 2018/1/25.
 */

public class ExtremeApp extends Application {

    private static class ExtremeAppHolder {
        private static final ExtremeApp INSTANCE = new ExtremeApp();
    } ;

    /** 单例模式 ----- 静态内部内的生成方式   线程安全，懒加载 */
    private static ExtremeApp getExtremeAppContext() {
        return ExtremeAppHolder.INSTANCE;
    }



}
