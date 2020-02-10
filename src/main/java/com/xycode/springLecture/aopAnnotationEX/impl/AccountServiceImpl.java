package com.xycode.springLecture.aopAnnotationEX.impl;

import com.xycode.springLecture.aopAnnotationEX.Account;
import com.xycode.springLecture.aopAnnotationEX.dao.IAccountDao;
import com.xycode.springLecture.aopAnnotationEX.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: AccountServiceImpl
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the AccountServiceImpl class
 **/
@Service("com.xycode.springLecture.aopAnnotationEX.impl.accountService")
@ComponentScan(basePackages = "com.xycode.springLecture.aopAnnotationEX")
public class AccountServiceImpl implements IAccountService {
    @Resource(name = "com.xycode.springLecture.aopAnnotationEX.impl.accountDao")
    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
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

    @Override
    public void transfer(int srcID, int dstID, float money) {
        accountDao.transfer(srcID,dstID,money);
    }

}
