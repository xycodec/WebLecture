package com.xycode.springLecture.aopEX.impl;

import com.xycode.springLecture.aopEX.Account;
import com.xycode.springLecture.aopEX.dao.IAccountDao;
import com.xycode.springLecture.aopEX.impl.ts.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: AccountDaoImpl
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: 使用QueryRunner搭配自实现的事务管理器(通过Spring AOP机制)
 **/
//数据访问层的具体实现
//JdbcDaoSupport是spring提供的通用Dao,继承它之后可以省掉一些setter/getter代码
public class AccountDaoImplWithMyTs implements IAccountDao {
    //tip: 使用QueryRunner而不是JdbcTemplate,以便与自定义的事务管理器结合使用
    private QueryRunner queryRunner;
    //connectionUtils会提供数据库连接,保证其是线程绑定的connection,一遍提供事务支持
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAllAccount() {
        List<Account> result= null;
        try {
            result = queryRunner.query(connectionUtils.getConnection(), "select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Account findAccountByID(int id) {
        Account result= null;
        try {
            result = queryRunner.query(connectionUtils.getConnection(),"select * from account where id=?",new BeanHandler<>(Account.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void addAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getConnection(),"insert into account values (?,?,?,?)",account.getId(),
                    account.getUsername(),account.getPassword(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getConnection(),"update account set username=?,password=?,money=? where id=?",account.getUsername(),
                    account.getPassword(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(int id) {
        try {
            queryRunner.update(connectionUtils.getConnection(),"delete from account where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transfer(int srcID, int dstID, float money) {
        System.out.println("transfer...");
        Account srcAccount=findAccountByID(srcID);
        Account dstAccount=findAccountByID(dstID);
        if(srcAccount.getMoney()<money){
            System.err.println(srcID+" has not enough money");
        }else{
            srcAccount.setMoney(srcAccount.getMoney()-money);
            dstAccount.setMoney(dstAccount.getMoney()+money);
        }
        updateAccount(srcAccount);
        int i=1/0;//tip: 手动模拟异常,看事务管理是否起作用
        //notice: 结果: 这里是与QueryRunner结合使用,最后达到了事务管理的效果
        updateAccount(dstAccount);
    }
}
