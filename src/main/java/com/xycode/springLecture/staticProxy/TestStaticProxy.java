package com.xycode.springLecture.staticProxy;

import org.testng.annotations.Test;

/**
 * ClassName: TestStaticProxy
 *
 * @Author: xycode
 * @Date: 2020/2/16
 * @Description: this is description of the TestStaticProxy class
 **/
public class TestStaticProxy {
    //测试静态代理模式
    @Test
    public void testStaticProxy(){
        Target target=new TargetImpl();
        ProxyClass proxyClass=new ProxyClass(target);
        proxyClass.enhancedSayHello();
    }
}
