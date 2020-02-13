package com.xycode.springmvcLecture.controller;

import com.xycode.springmvcLecture.controller.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: InterceptorController
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the InterceptorController class
 **/
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    @RequestMapping("/testInterceptor1")
    public String testInterceptor1() throws Exception {
        System.out.println("----------------testInterceptor1--------------------");
        //notice: 注意这个方法会被配置好的拦截器MyInterceptor拦截
        return "error";//如果没有异常就会跳转到success.jsp
    }
}
