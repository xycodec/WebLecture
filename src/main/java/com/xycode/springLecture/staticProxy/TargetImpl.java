package com.xycode.springLecture.staticProxy;

/**
 * ClassName: TargetImpl
 *
 * @Author: xycode
 * @Date: 2020/2/16
 * @Description: this is description of the TargetImpl class
 **/
public class TargetImpl implements Target {

    @Override
    public void sayHello() {
        System.out.println("statusProxy say hello");
    }
}
