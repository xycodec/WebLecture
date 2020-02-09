package com.xycode.springLecture.demos.serviceImpl;

import com.xycode.springLecture.demos.service.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * ClassName: AppService
 *
 * @Author: xycode
 * @Date: 2020/2/7
 * @Description: this is description of the AppService class
 **/

//这里的value相当于xml中bean标签里的id,如果我们不写,其值默认为当前类名(首字母改小写)
//tip: 除了Component,有类似功能的注解还有Service,Repository,Controller,用法类似Component,以上注解作用都是创建
//@org.springframework.stereotype.Service(value = "annotationAppService")
@Component(value = "annotationAppService")
//@Controller(value = "annotationAppService")
//@Repository(value = "annotationAppService")

@Scope("prototype")
public class AppServiceImpl implements Service {
    //value注解方式注入数据,作用类似set方式注入,只限于基本数据类型与String
    @Value("annotation") private String name;


//    @Autowired //Autowired注解无法处理存在多个相同类型的bean的情况,所以往往需要搭配Qualifier来使用
//    @Qualifier("DateBean")//不能单独使用,需要搭配AutoWire
    @Resource(name = "DateBean")//Resource注解可以替代Autowired+Qualifier
    private Date birthday;
    public AppServiceImpl() {
        System.out.println("AppService is constructed");
    }

    public AppServiceImpl(String name) {
        this.name = name;
        System.out.println("AppService-"+name+ " is constructed");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //PostConstruct注解指定bean的初始化方法
    @PostConstruct
    public void init(){
        System.out.println((name==null?"AppService":"AppService-"+name) + " is init");
    }

    //PreDestroy注解指定bean的销毁方法
    @PreDestroy
    public void destroy(){
        System.out.println((name==null?"AppService":"AppService-"+name) + " is destroyed");
    }

    @Override
    public void service() {
        System.out.println((name==null?"AppService":"AppService-"+name) + " is on service");
        if(birthday!=null) System.out.println("\t birthday: "+birthday);
    }
}
