package com.xycode.springmvcLecture.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * ClassName: User
 *
 * @Author: xycode
 * @Date: 2020/2/11
 * @Description: this is description of the User class
 **/
public class User implements Serializable {
    private String username;
    private String password;
    private Double money;

    private List<InternalInformation> list;

    private Map<String,InternalInformation> map;

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<InternalInformation> getList() {
        return list;
    }

    public void setList(List<InternalInformation> list) {
        this.list = list;
    }

    public Map<String, InternalInformation> getMap() {
        return map;
    }

    public void setMap(Map<String, InternalInformation> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

}
