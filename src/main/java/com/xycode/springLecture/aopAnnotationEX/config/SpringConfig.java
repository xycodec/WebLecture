package com.xycode.springLecture.aopAnnotationEX.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: SpringConfig
 *
 * @Author: xycode
 * @Date: 2020/2/10
 * @Description: this is description of the SpringConfig class
 **/
@Configurable
@EnableTransactionManagement
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("classpath:druid.properties")
public class SpringConfig {

}
