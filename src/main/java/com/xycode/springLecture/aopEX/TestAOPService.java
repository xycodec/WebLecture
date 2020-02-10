package com.xycode.springLecture.aopEX;

import com.xycode.springLecture.aopEX.Account;
import com.xycode.springLecture.aopEX.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: TestAccountService
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the TestAccountService class
 **/
public class TestAOPService {
    @Test
    public void testAOPService(){
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aopEX.xml");//warn: 不能搭配JdbcTemplate,起不到事务管理的作用
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aopTsEX.xml");//notice: 使用spring提供的事务管理器(仅通过配置xml文件)
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aopMyTsEX.xml");//使用QueryRunner搭配自实现的事务管理器
        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);

//        System.out.println("addAccount():");
//        accountService.addAccount(new Account(1237,"xxoo","123456", (float) 12345.2));
//        System.out.println(accountService.findAccountByID(1237));
//
//        System.out.println("updateAccount():");
//        accountService.updateAccount(new Account(1237,"xxoo","123456", (float) 3456.678));
//        System.out.println(accountService.findAccountByID(1237));
//
//        System.out.println("deleteAccount():");
//        accountService.deleteAccount(1237);
//        System.out.println(accountService.findAllAccount());

        //notice: 测试自定义的事务管理是否生效(手动在transfer()中引发异常), 结果表明的确生效了
        System.out.println(accountService.findAllAccount());
        System.out.println("--------------------------------");
        System.out.println("transfer():");
        accountService.transfer(1235,1236,100f);
    }
}
