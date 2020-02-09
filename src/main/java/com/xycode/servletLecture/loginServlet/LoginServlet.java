package com.xycode.servletLecture.loginServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: LoginServlet
 *
 * @Author: xycode
 * @Date: 2020/1/19
 * @Description: 处理登录逻辑的Servlet
 **/

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("----------(LoginServlet)doGet----------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username+":"+password);
        User loginUser=new User(username,password);

        UserDao dao=new UserDao();
        User result=dao.login(loginUser);
        if(result==null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            req.setAttribute("user",result);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }
}
