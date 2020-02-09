package com.xycode.springLecture.accountEx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * ClassName: JDBCConfig
 *
 * @Author: xycode
 * @Date: 2020/2/9
 * @Description: this is description of the JDBCConfig class
 **/
//@Configurable
@ComponentScan("com.xycode.springLecture")
public class JdbcConfig {
    @Value("${driverClassName}") private String driverClassName;
    @Value("${url}") private String url;
    @Value("${jdbc.username}") private String username;
    @Value("${password}") private String password;
    //Bean注解会将修饰的方法的返回的对象存到IOC容器中,key=name,value=返回值
    //当修饰的函数带有参数时会再IOC容器中查找相应的bean(以参数名为key)
    @Bean(name="jdbcTemplate")
    @Scope("prototype")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean("dataSource")
    public DataSource createDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
//        System.out.println(driverClassName);
//        System.out.println(url);
//        System.out.println(username);//warn: 当使用${username}时,会读取出电脑用户名xycode,而不是配置文件中的root
//        System.out.println(password);
        return dataSource;
    }
}
