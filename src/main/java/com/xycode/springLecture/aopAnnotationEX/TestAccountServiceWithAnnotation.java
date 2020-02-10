package com.xycode.springLecture.aopAnnotationEX;

import com.xycode.springLecture.accountAnnotationEX.Account;
import com.xycode.springLecture.accountAnnotationEX.config.AccountConfig;
import com.xycode.springLecture.accountAnnotationEX.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;

/**
 * ClassName: TestAccountService
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the TestAccountService class
 **/
public class TestAccountServiceWithAnnotation {
    @Test
    public void testAccountServiceWithAnnotation(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AccountConfig.class);
        IAccountService accountService=applicationContext.getBean("com.xycode.springLecture.accountAnnotationEX.impl.accountService",IAccountService.class);
        System.out.println("findAccountByID:");
        System.out.println(accountService.findAccountByID(1234));

        List<Account> list=accountService.findAllAccount();
        System.out.println("findAllAccount:");
        for (Account account : list) {
            System.out.println(account);
        }

        System.out.println("addAccount:");
        accountService.addAccount(new Account(1237,"xxoo","123456", (float) 12345.2));
        System.out.println(accountService.findAccountByID(1237));

        System.out.println("updateAccount:");
        accountService.updateAccount(new Account(1237,"xxoo","123456", (float) 3456.678));
        System.out.println(accountService.findAccountByID(1237));

        System.out.println("deleteAccount:");
        accountService.deleteAccount(1237);
        System.out.println(accountService.findAllAccount());

    }
}
