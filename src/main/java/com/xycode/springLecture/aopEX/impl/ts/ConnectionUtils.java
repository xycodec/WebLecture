package com.xycode.springLecture.aopEX.impl.ts;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ClassName: DBUtils
 *
 * @Author: xycode
 * @Date: 2020/2/9
 * @Description: 数据库连接管理,因为对于若要管理数据库操作事务,必须保证所使用的Connection一致,
 *               这里采用ThreadLocal方式将唯一的Connection与线程绑定,从而达到事务一致性.
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
