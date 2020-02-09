package com.xycode.springLecture.accountEx;

import java.io.Serializable;

/**
 * ClassName: Account
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the Account class
 **/
public class Account implements Serializable {
    private int id;
    private String username;
    private String password;
    private float money;

    public Account() {
    }

    public Account(int id, String username, String password, float money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
