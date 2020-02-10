package com.xycode.springLecture.aopEX.impl.ts;

import java.sql.SQLException;

/**
 * ClassName: TransactionManager
 *
 * @Author: xycode
 * @Date: 2020/2/9
 * @Description: 事务管理的工具类
 **/
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //开启事务
    public void startTransaction(){
        try {
            //禁用自动提交,让TransactionManager来管理事务
            System.out.println("--> startTransaction");
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public void commit(){
        try {
            System.out.println("--> commit");
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚事务
    public void rollback(){
        try {
            System.out.println("--> rollback");
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //终止事务(释放连接)
    public void release(){
        try {
            System.out.println("--> release");
            connectionUtils.getConnection().close();
            //tip: 这里的close实际上并不是真正的关闭,而是将连接放回到连接池中,所以这里需要手动解除Connection与线程的关系
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
