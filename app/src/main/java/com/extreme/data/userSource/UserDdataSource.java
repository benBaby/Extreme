package com.extreme.data.userSource;

import com.extreme.data.model.User;

/**
 * Created by ZZ on 2018/1/31.
 */

public interface UserDdataSource {

    interface getUserCallBack {
        void onLoadUser(User user);
    }

    void getUser(getUserCallBack callBack);

    void deleteUser();

    void addUser();

    void changeUser();

}
