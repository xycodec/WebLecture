package com.xycode.springLecture.accountAnnotationEX;

import com.xycode.springLecture.aopAnnotationEX.Account;
import com.xycode.springLecture.aopAnnotationEX.config.SpringConfig;
import com.xycode.springLecture.aopAnnotationEX.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * ClassName: TestAccountService
 *
 * @Author: xycode
 * @Date: 2020/2/8
 * @Description: this is description of the TestAccountService class
 **/
public class TestAOPServiceWithAnnotation {
    @Test
    public void testAOPServiceWithAnnotation(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        IAccountService accountService=applicationContext.getBean("com.xycode.springLecture.aopAnnotationEX.impl.accountService", IAccountService.class);

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

        //notice: 测试事务管理是否生效(手动在transfer()中引发异常), 结果表明的确生效了
        System.out.println("--------------------------------");
        System.out.println(accountService.findAllAccount());
        System.out.println("transfer():");
        accountService.transfer(1235,1236,100f);
    }
}
