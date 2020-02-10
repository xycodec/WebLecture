package com.xycode.springLecture.accountAnnotationEX.config;

import org.springframework.context.annotation.*;

/**
 * ClassName: AccountConfig
 *
 * @Author: xycode
 * @Date: 2020/2/9
 * @Description: this is description of the AccountConfig class
 **/

//Configurable注解指定这是个SpringConfig,但是当使用ClassPathXmlApplicationContext有参数构造时,这个Configure注解就不必要,
//  但是若这个配置类作为某个子配置时,即ClassPathXmlApplicationContext的构造参数参数为父配置类的路径,这时就需要了(当然,也可以使用Import注解)
//ComponentScan指定SpringConfig作用的包(要扫描的包)
//@Configurable
@ComponentScan(basePackages = "com.xycode.springLecture.accountAnnotationEX")
@Import(JdbcConfig.class) //导入子配置类
@PropertySource("classpath:druid.properties")
public class AccountConfig {

}
