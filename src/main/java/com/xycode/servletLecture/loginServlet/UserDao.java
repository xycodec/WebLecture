package com.xycode.servletLecture.loginServlet;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
//        User loginUser=new User("xycode","pass");
//        UserDao dao=new UserDao();
//        User result=dao.login(loginUser);
//        System.out.println(result.getUsername()+":"+result.getPassword());

        try {

            //RowMapper接口描述数据长什么样儿,ResultSet可以根据索引或键值来获取数据
            List<User> list=template.query("select * from user", new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new User(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3));
                }
            });
//            List<User> list=template.query(sql, (rs, rowNum) -> new User(rs.getInt("id"),
//                    rs.getString("username"),rs.getString("password")));
            for(User user:list){
                System.out.println(user);
            }

            System.out.println("total: "+template.queryForObject("select count(*) from user",Integer.class));
            System.out.println(template.queryForMap("select * from user where username='xuyan'"));
//            System.out.println(template.update("insert into user values (?,?,?)",1238,"xxoo","987651"));
        }catch (DataAccessException e){
            e.printStackTrace();
        }
    }
}
