package com.xycode.loginServlet;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;

/**
 * ClassName: UserDao
 *
 * @Author: xycode
 * @Date: 2020/1/19
 * @Description: User实例与数据库之间的中间层
 **/
public class UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User loginUser){
        String sql="select * from user where username = ? and password = ?";
        try {
            User result=template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(),loginUser.getPassword()
            );
            return result;
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testUserDao(){
        User loginUser=new User("xycode","pass");
        UserDao dao=new UserDao();
        User result=dao.login(loginUser);
        System.out.println(result.getUsername()+":"+result.getPassword());
    }
}
