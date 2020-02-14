package com.xycode.ssmEX.service;


import com.xycode.ssmEX.domain.User;

import java.util.List;

/**
 * InterfaceName: UserService
 *
 * @Author: xycode
 * @Date: 2020/2/15
 * @Description: 业务层接口
 **/
public interface IUserService {
    List<User> findAllUser();

    //增
    void addUser(User user);

    //删
    void deleteUser(int id);

    //改
    void updateUser(User user);

    //查
    User findUserByID(int id);
}
