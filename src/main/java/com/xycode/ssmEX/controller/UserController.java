package com.xycode.ssmEX.controller;

import com.xycode.ssmEX.domain.User;
import com.xycode.ssmEX.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: UserController
 *
 * @Author: xycode
 * @Date: 2020/2/15
 * @Description: 表现层(控制器层)
 **/
@Controller
@RequestMapping("/userService")
public class UserController {
//    在web.xml中配置好整合spring与springmvc后,在这里(springmvc),就可以使用spring的方式来依赖注入了
    @Resource(name = "userService")
    private IUserService userService;
    @RequestMapping("/findAllUser")
    public String findAllUser(Model model){
        System.out.println("表现层: findAllUser");
        List<User> userList=userService.findAllUser();
//        System.out.println(userList);
        model.addAttribute("userList",userList);
        return "userList";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        System.out.println("表现层: addUser");
        userService.addUser(user);
        return "success";
    }

    //rest风格的url
    @RequestMapping(value = "/deleteUserByID/{id}",method = RequestMethod.POST)
    public String deleteUserByID(@PathVariable(name = "id") int id){
        System.out.println("表现层: deleteUserByID");
        userService.deleteUser(id);
        return "success";
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(User user){
        System.out.println("表现层: updateUser");
        userService.updateUser(user);
        return "success";
    }

    //rest风格的url
    @RequestMapping(value = "/findUserByID/{id}",method = RequestMethod.POST)
    //warn: model要放到前面,否则PathVariable注解会把它一起修饰了...
    public String findUserByID(Model model,@PathVariable(name = "id")int id) {
        System.out.println("表现层: findUserByID");
        User user=userService.findUserByID(id);
        if(user!=null){
            model.addAttribute("foundUser",user);
        }
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return "userEntry";
    }

}
