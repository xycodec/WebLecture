package com.xycode.springLecture.accountEX.service;

import com.xycode.springLecture.accountEX.Account;

import java.util.List;

/**
 * InterfaceName: IAccountService
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the interface
 **/
public interface IAccountService {
    List<Account> findAllAccount();

    Account findAccountByID(int id);

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(int id);

}
