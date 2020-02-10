package com.xycode.springLecture.aopAnnotationEX.impl;

import com.xycode.springLecture.aopAnnotationEX.Account;
import com.xycode.springLecture.aopAnnotationEX.dao.IAccountDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: AccountDaoImpl
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the AccountDaoImpl class
 **/
//数据访问层的具体实现
//warn: 注解方式最好不要和JdbcDaoSupport一起使用,包中的jdbcTemplate变量使用注解不好注入
@Repository("com.xycode.springLecture.aopAnnotationEX.impl.accountDao")
@ComponentScan(basePackages = "com.xycode.springLecture.aopAnnotationEX.config")
@Transactional(propagation = Propagation.REQUIRED)//Transactional注解:配置事务管理器
public class AccountDaoImpl implements IAccountDao {
    //notice: 这里因为idea检测机制的问题,显示错误,其实是没错的
    @Resource(name = "com.xycode.springLecture.aopAnnotationEX.config.jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAllAccount() {
        List<Account> result=jdbcTemplate.query("select * from account", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Account(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getFloat("money"));
            }
        });
        return result;
    }

    @Override
    public Account findAccountByID(int id) {
        Account result=jdbcTemplate.queryForObject("select * from account where id=?",new BeanPropertyRowMapper<>(Account.class),id);
        return result;
    }

    @Override
    public void addAccount(Account account) {
        jdbcTemplate.update("insert into account values (?,?,?,?)",account.getId(),
                account.getUsername(),account.getPassword(),account.getMoney());
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set username=?,password=?,money=? where id=?",account.getUsername(),
                account.getPassword(),account.getMoney(),account.getId());
    }

    @Override
    public void deleteAccount(int id) {
        jdbcTemplate.update("delete from account where id=?",id);
    }

    @Override
    public void transfer(int srcID, int dstID, float money) {
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
        //notice: 结果: 对于jdbcTemplate来说,由于没有关联Connection的查询方法,故无法起到事务管理的作用(虽然确实能调用到指定的方法)
        //      而对于spring的事务管理器来说,在xml文件汇总配置好,起到了事务管理的作用
        updateAccount(dstAccount);
    }
}
