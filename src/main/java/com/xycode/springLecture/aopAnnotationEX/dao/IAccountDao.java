package com.xycode.springLecture.aopAnnotationEX.dao;

import com.xycode.springLecture.aopAnnotationEX.Account;

import java.util.List;

/**
 * ClassName: IAccountDao
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the IAccountDao class
 **/
//数据访问层接口
public interface IAccountDao{
    List<Account> findAllAccount();

    Account findAccountByID(int id);

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(int id);

    void transfer(int srcID, int dstID, float money);
}
