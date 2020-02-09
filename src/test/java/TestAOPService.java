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
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aopTsEX.xml");//notice: 使用spring提供的事务管理器(仅通过配置xml文件)
        IAccountService accountService=applicationContext.getBean("accountService",IAccountService.class);
        List<Account> list=accountService.findAllAccount();
        System.out.println("findAllAccount:");
        for (Account account : list) {
            System.out.println(account);
        }

        System.out.println("transfer:");
        accountService.transfer(1235,1236,1000f);

        list=accountService.findAllAccount();
        System.out.println("findAllAccount:");
        for (Account account : list) {
            System.out.println(account);
        }

    }
}
