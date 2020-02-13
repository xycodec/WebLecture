package com.xycode.springmvcLecture.controller;

import com.xycode.springmvcLecture.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
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
@RequestMapping("/response")
public class ResponseController {
    @RequestMapping("/testResponse1")
    public String testResponse1(Model model){
        System.out.println("------------testResponse1-------------");
        User user=new User();
        user.setUsername("xycode");
        user.setPassword("pass");
        user.setMoney(12345.67);
        //model可以理解为一个全局的map,其中数据可以共享
        model.addAttribute("user",user);
        return "response";
    }

    //注意这个方法没有返回值,也就是说页面解析器获取不到文件名,所以这里使用原生Servlet进行转发
    @RequestMapping("/testForward1")
    public void testForward1(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        System.out.println("------------testForward1-------------");
        User user=new User();
        user.setUsername("xycode");
        user.setPassword("pass");
        user.setMoney(12345.67);
        //model可以理解为一个全局的map,其中数据可以共享
        model.addAttribute("user",user);
        //这里其实本质上就是使用原生Servlet做一些操作,貌似获取不到user,可能是因为这是原生Servlet
        //请求转发
        request.getRequestDispatcher("/WEB-INF/pages/response.jsp").forward(request,response);
        //重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }


    @RequestMapping("/testForward2")
    public String testForward2(Model model) throws ServletException, IOException {
        System.out.println("------------testForward2-------------");
        User user=new User();
        user.setUsername("徐岩");
        user.setPassword("123456");
        user.setMoney(45789.87);
        //model可以理解为一个全局的map,其中数据可以共享
        model.addAttribute("user",user);
        return "forward:/WEB-INF/pages/response.jsp";//spring mvc会自动识别到forward进而转发
        //重定向
//        return "redirect:/index.jsp";
    }


}
