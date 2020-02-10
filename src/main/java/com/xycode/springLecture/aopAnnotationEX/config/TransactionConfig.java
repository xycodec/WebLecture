package com.xycode.springLecture.aopAnnotationEX.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * ClassName: SpringConfig
 *
 * @Author: xycode
 * @Date: 2020/2/10
 * @Description: this is description of the SpringConfig class
 **/
@ComponentScan(basePackages = "com.xycode.springLecture.aopAnnotationEX")
public class TransactionConfig {

    @Bean(name = "com.xycode.springLecture.aopAnnotationEX.config.transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
