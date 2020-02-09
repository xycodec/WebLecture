package com.xycode.servletLecture.loginServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: FailServlet
 *
 *
 * @Author: xycode
 * @Date: 2020/1/19
 * @Description: 登录成功的页面处理Servlet
 **/
@WebServlet(urlPatterns = "/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("----------(SuccessServlet)doGet----------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user= (User) req.getAttribute("user");
        if(user!=null){
//            resp.setCharacterEncoding("utf-8");//单方面地设置resp的编码为utf-8,并未指定浏览器使用什么编码
//            resp.setHeader("content-type","text/html;charset=utf-8");
            resp.setContentType("text/html;charset=utf-8");//设置消息头,建议浏览器使用utf-8编码,相当于 resp.setHeader("content-type","text/html;charset=utf-8")
            resp.getWriter().write("登录成功!\n"+user.getUsername()+", 欢迎您");
            //getWriter()得到的是字符流,若要得到字节流,如下所示
//            resp.getOutputStream().write("你好".getBytes());
        }
    }
}
