package com.xycode.springLecture.aopAnnotationEX.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * ClassName: SpringConfig
 *
 * @Author: xycode
 * @Date: 2020/2/10
 * @Description: this is description of the SpringConfig class
 **/
@ComponentScan(basePackages = "com.xycode.springLecture.aopAnnotationEX")
public class JdbcConfig {
    @Value("${driverClassName}") private String driverClassName;
    @Value("${url}") private String url;
    @Value("${jdbc.username}") private String username;//warn: 当使用${username}时,会读取出电脑用户名xycode,而不是配置文件中的root
    @Value("${password}") private String password;
    //Bean注解会将修饰的方法的返回的对象存到IOC容器中,key就是name,而value是函数返回值
    //当修饰的函数带有参数时会再IOC容器中查找相应的bean(以参数名为key)

    @Bean(name="com.xycode.springLecture.aopAnnotationEX.config.jdbcTemplate")
    @Scope("prototype")
    public JdbcTemplate createJdbcTemplate(@Qualifier("com.xycode.aopAnnotationEX.config.dataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean("com.xycode.aopAnnotationEX.config.dataSource")
    public DataSource createDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
