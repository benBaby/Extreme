package com.extreme.customListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 观察者
 * Created by ZZ on 2018/1/26.
 */

public class ShowRefreshManager {

    private List<ShowRefreshListener> listenerList = new CopyOnWriteArrayList<>();

    private static class ShowRefreshHolder {
        private static final ShowRefreshManager INSTANCE = new ShowRefreshManager();
    }

    public static ShowRefreshManager newInstance() {
        return ShowRefreshHolder.INSTANCE;
    }

    public void registered(ShowRefreshListener listener) {
        listenerList.add(listener);
    }

    public void unRegisterListener(ShowRefreshListener listener) {
        listenerList.remove(listener);
    }

    public void sendBroadCast() {
        for (ShowRefreshListener listener : listenerList) {
            listener.onRefresh();
        }
    }

    public void sendBroadCast(Object object) {
        for (ShowRefreshListener listener : listenerList) {
            listener.onRefresh(object);
        }
    }
}
