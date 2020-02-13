package com.xycode.springLecture.accountEX.impl;

import com.xycode.springLecture.accountEX.Account;
import com.xycode.springLecture.accountEX.dao.IAccountDao;
import com.xycode.springLecture.accountEX.service.IAccountService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: AccountServiceImpl
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the AccountServiceImpl class
 **/
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
//        System.out.println(accountDao);
//        System.out.println(((AccountDaoImpl) accountDao).getJdbcTemplate());
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountByID(int id) {
        return accountDao.findAccountByID(id);
    }

    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }

}
