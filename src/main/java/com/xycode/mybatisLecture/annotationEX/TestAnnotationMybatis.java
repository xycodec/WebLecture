package com.xycode.mybatisLecture.annotationEX;

import com.xycode.mybatisLecture.annotationEX.dao.IUserDao;
import com.xycode.mybatisLecture.annotationEX.domain.MappedUser;
import com.xycode.mybatisLecture.annotationEX.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: TestMybatis
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the TestMybatis class
 **/
public class TestAnnotationMybatis {
    private SqlSession session;
    private IUserDao userDao;
    @BeforeTest
    public void init() throws IOException {
        System.out.println("create mybatis session...");
        //读取配置文件(底层就是类加载器那一套)
        InputStream is = Resources.getResourceAsStream("mybatis/mybatisAnnotation-config.xml");
        //初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建Session实例
        session = sqlSessionFactory.openSession();
        //根据IUserDao接口的字节码创建dao的代理对象
        userDao=session.getMapper(IUserDao.class);
    }

    @Test
    public void testCrud() {
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


//        //事务提交,如果没有commit的话,虽然下面可以打印出更新的结果,但是当session关闭时,数据库中实际上是不会被更新的
//        session.commit();
    }

    //notice: 这里的MappedUser的成员变量名与数据库中的不一致,所以使用了@Results与@ResultMap注解封装了返回结果,从而达到兼容的效果
    @Test
    public void testMappedCrud() {
        MappedUser user=new MappedUser(1000,"newUserXXOO","123456",989723.1f);
        System.out.println("--> addMappedUser("+user+"):");
        userDao.addMappedUser(user);

        user=new MappedUser(1000,"newUserXXOO","xxxooo",334542.3f);
        System.out.println("--> updateMappedUser("+user+"):");
        userDao.updateMappedUser(user);

        System.out.println("--> findMappedUserByID(1000):");
        System.out.println(userDao.findMappedUserByID(1000));

        System.out.println("--> deleteMappedUser(1000):");
        userDao.deleteMappedUser(1000);

        System.out.println("--> findAllMappedUser():");
        System.out.println(userDao.findAllMappedUser());


//        //事务提交,如果没有commit的话,虽然下面可以打印出更新的结果,但是当session关闭时,数据库中实际上是不会被更新的
//        session.commit();
    }

    @AfterTest
    public void destroy(){
        System.out.println("destroy mybatis session...");
        if(session!=null) session.close();
    }
}
