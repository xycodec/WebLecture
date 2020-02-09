package com.xycode.servletLecture.loginServlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: JDBCUtils
 *
 * @Author: xycode
 * @Date: 2020/1/19
 * @Description: 操作数据库的工具类
 **/
public class JDBCUtils  {
    private static DataSource ds;
    static{
        Properties p=new Properties();
        try {
//            System.out.println(JDBCUtils.class.getResource(""));
            p.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds=DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
