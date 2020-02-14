package com.xycode.ssmEX.service.impl;

import com.xycode.ssmEX.dao.IUserDao;
import com.xycode.ssmEX.domain.User;
import com.xycode.ssmEX.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: UserServiceImpl
 *
 * @Author: xycode
 * @Date: 2020/2/15
 * @Description: 业务层实现类
 **/
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource(name = "userDao")
    private IUserDao userDao;

    @Override
    public List<User> findAllUser() {
        System.out.println("userService invoke findAllUser");
        return userDao.findAllUser();
    }

    @Override
    public void addUser(User user) {
        System.out.println("userService invoke addUser");
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("userService invoke deleteUser");
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("userService invoke updateUser");
        userDao.updateUser(user);
    }

    @Override
    public User findUserByID(int id) {
        System.out.println("userService invoke findUserByID");
        return userDao.findUserByID(id);
    }
}
