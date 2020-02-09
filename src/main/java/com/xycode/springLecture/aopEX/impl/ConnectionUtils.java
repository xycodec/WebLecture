package com.xycode.springLecture.aopEX.impl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ClassName: DBUtils
 *
 * @Author: xycode
 * @Date: 2020/2/9
 * @Description: this is description of the dbUtils class
 **/
public class ConnectionUtils {
    private ThreadLocal<Connection> connectionThreadLocal=new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public synchronized Connection getConnection(){
        Connection connection=connectionThreadLocal.get();
        if(connection==null){
            try {
                connectionThreadLocal.set(connection=dataSource.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public synchronized void removeConnection(){
        connectionThreadLocal.remove();//移出存储的数据,相当于解绑Connection与线程的关系
    }

}
