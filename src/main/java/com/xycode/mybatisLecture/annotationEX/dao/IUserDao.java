package com.xycode.mybatisLecture.annotationEX.dao;

import com.beust.jcommander.Parameter;
import com.xycode.mybatisLecture.annotationEX.domain.MappedUser;
import com.xycode.mybatisLecture.annotationEX.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * InterfaceName: IUserDao
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the interface
 **/
public interface IUserDao {
    //使用注解方式配置
    @Select("select * from account;")
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



//  notice: 使用Results注解封装返回结果,这个通常用来兼容数据库数据格式与实现类,这里就是简单地换了个变量名字
    @Select("select * from account;")
    //tip: 这里为Results指定id,这样的话可以共享给其它方法,其它方法可以这样引用: ResultMap({"userMap"})
    @Results(id = "userMap",value = {
            @Result(id=true,column = "id",property = "uid"),
            @Result(column = "username",property = "uname"),
            @Result(column = "password",property = "password"),
            @Result(column = "money",property = "remainMoney")

    }) List<MappedUser> findAllMappedUser();

    //增
    @Insert("insert into account values(#{uid},#{uname},#{password},#{remainMoney})")
    void addMappedUser(MappedUser user);

    //删
    @Delete("delete from account where id=#{uid}")
    @ResultMap({"userMap"})
    void deleteMappedUser(int uid);

    //改
    @Update("update account set username=#{uname},password=#{password},money=#{remainMoney} where id=#{uid}")
    @ResultMap({"userMap"})
    void updateMappedUser(MappedUser user);

    //查
    @Select("select * from account where id=#{uid}")
    @ResultMap({"userMap"})
    MappedUser findMappedUserByID(int uid);



//
//    //条件查询
//    List<User> findUserByCondition(User user);
}
