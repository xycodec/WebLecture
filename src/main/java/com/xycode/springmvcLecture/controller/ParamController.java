package com.xycode.springmvcLecture.controller;

import com.xycode.springmvcLecture.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: ParamController
 *
 * @Author: xycode
 * @Date: 2020/2/11
 * @Description: this is description of the ParamController class
 **/
//tip: 测试请求参数绑定
@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam1")
    //参数列表会自动与提交链接匹配key,以此获得对应的value
    public String testParam1(String username,String password){
        System.out.println("------------testParam1-------------");
        System.out.println("用户名: "+username);
        System.out.println("密码: "+password);
        return "success";
    }

    @RequestMapping("/testParam2")
    public String testParam2(User user){
        System.out.println("------------testParam2-------------");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("------------testServlet-------------");
        //获取原生Servlet对象
        System.out.println(request);
        System.out.println(response);
        return "success";
    }
}
