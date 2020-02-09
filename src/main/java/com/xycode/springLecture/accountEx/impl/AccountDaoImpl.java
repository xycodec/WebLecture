package com.xycode.springLecture.accountEx.impl;

import com.xycode.springLecture.accountEx.Account;
import com.xycode.springLecture.accountEx.dao.IAccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
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
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

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
}
