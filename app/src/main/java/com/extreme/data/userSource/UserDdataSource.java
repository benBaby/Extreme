package com.extreme.data.userSource;

import com.extreme.data.model.User;

/**
 * 操作User数据的所有方法
 * Created by ZZ on 2018/1/31.
 */

public interface UserDdataSource {

    interface getUserCallBack {
        void onLoadUser(User user);
    }

    /**  获取数据 */
    void getUser(getUserCallBack callBack);

    /** 删除数据 */
    void deleteUser();

    /** 添加数据 */
    void addUser();

    /** 修改数据 */
    void changeUser();
}
