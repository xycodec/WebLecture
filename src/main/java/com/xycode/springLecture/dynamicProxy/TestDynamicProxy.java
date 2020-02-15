package com.xycode.springLecture.dynamicProxy;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: TestDynamicProxy
 *
 * @Author: xycode
 * @Date: 2020/2/16
 * @Description: this is description of the TestDynamicProxy class
 **/
public class TestDynamicProxy {
    @Test
    public void testDynamicProxy(){
        //使用jdk内置的Proxy类,Proxy.newProxyInstance为我们动态生成一个代理对象
        //这种方式的优势就是不用写那么多的代理类了,缺点就是只能代理某个interface的实现类
        Target proxyTarget= (Target) Proxy.newProxyInstance(Target.class.getClassLoader(),
                new Class<?>[]{Target.class}, new InvocationHandler() {
                    //增强代理的逻辑只需写在invoke方法中即可
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result=null;
                        //通过判断方法名进行针对性的代理,这里不对sayHello之外的方法进行代理
                        if(!"sayHello".equals(method.getName())){
                            result=method.invoke(new TargetImpl(),args);
                            return result;
                        }
                        System.out.println("--> 前置方法");
                        try {
                            //notice: 对TargetImpl的方法进行增强
                            result=method.invoke(new TargetImpl(),args);
//                            int i=1/0;//手动模拟异常
                            System.out.println("--> 后置方法");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("--> 异常方法");
                        } finally {
                            System.out.println("--> 最终方法");
                        }
                        return result;
                    }
                });

        //Proxy会默认代理接口的所有方法,当然了,可以在invoke()中判断方法名进行针对性的代理
        proxyTarget.sayHello();
        System.out.println("-------------------------");
        proxyTarget.sayHello2();
    }
}
