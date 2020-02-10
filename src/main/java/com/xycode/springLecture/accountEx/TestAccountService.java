package com.xycode.springLecture.accountEX;

import com.xycode.springLecture.accountEX.Account;
import com.xycode.springLecture.accountEX.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;

/**
 * ClassName: com.xycode.springLecture.accountEX.TestAccountService
 *
 * @Author: xycode
 * @Date: 2020/2/10
 * @Description: this is description of the com.xycode.springLecture.accountEX.TestAccountService class
 **/
public class TestAccountService {
    //warn: 这个测试会出现spring初始化失败的情况,猜测原因是xml配置文件与其它包的注解产生了冲突
    //fixme: 解决方法就是把accountAnnotationEX包与aopAnnotationEX标记为Excluded
    //tip: 当xml中的配置与注解的配置冲突时spring会优先选择xml的配置;
    // 除了xml配合注解使用的情况,最好不要出现xml与注解配置冲突,可能会产生意想不到的问题
    @Test
    public void testAccountService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("accountEX.xml");
        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
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
