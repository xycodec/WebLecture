package com.xycode.springLecture.demos;

import com.xycode.springLecture.demos.service.Service;
import com.xycode.springLecture.demos.serviceImpl.AppServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: SpringDemo1
 *
 * @Author: xycode
 * @Date: 2020/2/7
 * @Description: this is description of the SpringDemo1 class
 **/
public class SpringDemo3_Annotation {
    public static void main(String[] args) {
        //根据类路径来加载xml配置文件(效果类似classLoader方式)
        //ApplicationContext默认即时加载(单例,一经创建便会创建bean实例),可以通过配置xml来指定单例/多例等其它模式
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("annotationBeans.xml");

        //Component注解方式获取(创建)bean
        Service appService= (AppServiceImpl) applicationContext.getBean("annotationAppService");
        appService.service();

    }
}
