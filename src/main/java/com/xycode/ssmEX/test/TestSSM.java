package com.xycode.ssmEX.test;

import com.xycode.ssmEX.dao.IUserDao;
import com.xycode.ssmEX.domain.User;
import com.xycode.ssmEX.service.IUserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: TestSSM
 *
 * @Author: xycode
 * @Date: 2020/2/15
 * @Description: this is description of the TestSSM class
 **/
public class TestSSM {
//    测试spring
    @Test
    public void testService(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ssm/ssmEX.xml");
        IUserService userService=applicationContext.getBean("userService",IUserService.class);
        System.out.println(userService.findAllUser());
    }

//    测试mybatis
    @Test
    public void testDao() throws IOException {
        InputStream is = Resources.getResourceAsStream("ssm/mybatis-config.xml");
        //初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建Session实例
        SqlSession session = sqlSessionFactory.openSession();
        //根据IUserDao接口的字节码创建dao的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        //notice: 开始测试
        User user=new User(1000,"newUserXXOO","123456",989723.1f);
        System.out.println("--> addUser("+user+"):");
        userDao.addUser(user);

        user=new User(1000,"newUserXXOO","xxxooo",334542.3f);
        System.out.println("--> updateUser("+user+"):");
        userDao.updateUser(user);


        System.out.println("--> findUserByID(1000):");
        System.out.println(userDao.findUserByID(1000));

        System.out.println("--> deleteUser(1000):");
        userDao.deleteUser(1000);

        System.out.println("--> findAllUser():");
        System.out.println(userDao.findAllUser());
        //notice: 测试结束,关闭资源

        session.close();
        is.close();
    }

}
