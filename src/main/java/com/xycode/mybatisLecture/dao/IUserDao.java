package com.xycode.mybatisLecture.dao;

import com.xycode.mybatisLecture.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * InterfaceName: IUserDao
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the interface
 **/
public interface IUserDao {
    List<User> findAllUser();

    //增
    void addUser(User user);

    //删
    void deleteUser(int id);

    //改
    void updateUser(User user);

    //查
    User findUserByID(int id);

    //条件查询
    List<User> findUserByCondition(User user);
}
