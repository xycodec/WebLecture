package com.xycode.springmvcLecture.controller;

import com.xycode.springmvcLecture.controller.exception.MyException;
import com.xycode.springmvcLecture.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ResponseController
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the ResponseController class
 **/
@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/testException1")
    public String testException1() throws Exception {
        System.out.println("------------testException1-------------");
        //notice: 手动模拟异常
        try {
            int i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("自定义异常");
//            throw new Exception();
        }
        return "success";//如果没有异常就会跳转到success.jsp
    }


}
