package com.xycode.proxy.dynamicProxy;

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
        System.out.println("dynamicProxy say hello");
    }

    @Override
    public void sayHello2() {
        System.out.println("dynamicProxy say hello2");
    }
}
