package com.xycode.springmvcLecture.domain;

import java.io.Serializable;

/**
 * ClassName: InternalInformation
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the InternalInformation class
 **/
public class InternalInformation implements Serializable{
    private int id;
    private int level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "InternalInformation{" +
                "id=" + id +
                ", level=" + level +
                '}';
    }
}
