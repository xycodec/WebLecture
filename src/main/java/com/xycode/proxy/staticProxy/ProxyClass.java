package com.xycode.proxy.staticProxy;

/**
 * ClassName: ProxyClass
 *
 * @Author: xycode
 * @Date: 2020/2/16
 * @Description: this is description of the ProxyClass class
 **/
public class ProxyClass {
    private Target target;

    public ProxyClass(Target target) {
        this.target = target;
    }

    public void enhancedSayHello(){
        System.out.println("--> 前置方法");
        try {
            target.sayHello();
            System.out.println("--> 后置方法");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("--> 异常方法");
        } finally {
            System.out.println("--> 最终方法");
        }

    }

}
