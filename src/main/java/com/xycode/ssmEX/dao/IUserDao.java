package com.xycode.ssmEX.dao;


import com.xycode.ssmEX.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * InterfaceName: IUserDao
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: 持久层接口(数据访问层)
 **/
@Repository("userDao")
public interface IUserDao {
    @Select("select * from account")
    List<User> findAllUser();

    //增
    @Insert("insert into account values(#{id},#{username},#{password},#{money})")
    void addUser(User user);

    //删
    @Delete("delete from account where id=#{id}")
    void deleteUser(int id);

    //改
    @Update("update account set username=#{username},password=#{password},money=#{money} where id=#{id}")
    void updateUser(User user);

    //查
    @Select("select * from account where id=#{id}")
    User findUserByID(int id);

}
