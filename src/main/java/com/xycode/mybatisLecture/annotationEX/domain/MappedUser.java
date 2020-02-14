package com.xycode.mybatisLecture.annotationEX.domain;

/**
 * ClassName: User
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the User class
 **/
public class MappedUser {
    private int uid;
    private String uname;
    private String password;
    private double remainMoney;

    public MappedUser() {
    }

    public MappedUser(int uid, String uname, String password, double remainMoney) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.remainMoney = remainMoney;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(double remainMoney) {
        this.remainMoney = remainMoney;
    }

    @Override
    public String toString() {
        return "MappedUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", remainMoney=" + remainMoney +
                '}';
    }
}
