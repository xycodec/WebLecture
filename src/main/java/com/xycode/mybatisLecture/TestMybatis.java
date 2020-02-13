package com.xycode.mybatisLecture;

import com.xycode.mybatisLecture.dao.IUserDao;
import com.xycode.mybatisLecture.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName: TestMybatis
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the TestMybatis class
 **/
public class TestMybatis {
    private SqlSession session;
    private IUserDao userDao;
    @BeforeTest
    public void init() throws IOException {
        System.out.println("create mybatis session...");
        //读取配置文件(底层就是类加载器那一套)
        InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        //初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建Session实例
        session = sqlSessionFactory.openSession();
        //根据IUserDao接口的字节码创建dao的代理对象
        userDao=session.getMapper(IUserDao.class);
    }

    @Test
    public void testCrud() {
        User user=new User(1001,"newUserXXOO","123456",989723.1f);
        System.out.println("--> addUser("+user+"):");
        userDao.addUser(user);

        user=new User(1001,"newUserXXOO","xxxooo",334542.3f);
        System.out.println("--> updateUser("+user+"):");
        userDao.updateUser(user);


        System.out.println("--> findUserByID(1001):");
        System.out.println(userDao.findUserByID(1001));

        System.out.println("--> deleteUser(1001):");
        userDao.deleteUser(1001);

        System.out.println("--> findAllUser():");
        System.out.println(userDao.findAllUser());

//        //事务提交,如果没有commit的话,虽然下面可以打印出更新的结果,但是当session关闭时,数据库中实际上是不会被更新的
//        session.commit();
    }

    @Test
    public void testConditionQuery(){
        User user=new User();
        user.setPassword("pass");
        System.out.println(userDao.findUserByCondition(user));
    }

    @AfterTest
    public void destroy(){
        System.out.println("destroy mybatis session...");
        if(session!=null) session.close();
    }
}
