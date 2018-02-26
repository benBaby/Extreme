package com.extreme.data.model;

/**
 * Created by ZZ on 2018/1/26.
 */

public class User extends BaseModel{
    private int userid;
    private String userName;
    private String token;
    private int age;
    private String sex;

    public User(String userName, int age, String sex) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

}
