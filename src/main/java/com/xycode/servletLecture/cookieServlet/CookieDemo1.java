package com.xycode.servletLecture.cookieServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CookieDemo1
 *
 * @Author: xycode
 * @Date: 2020/2/5
 * @Description: this is description of the CookieDemo1 class
 **/

@WebServlet(urlPatterns = "/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("cookieMsg","this_is_cookieMsg");//cookie的value中不能包含空格
        resp.addCookie(cookie);//添加cookie
        //tip: 因为cookie本质上是一种客户端缓存技术,它的数据是从服务端得来的,所以这里通过response来添加cookie,后续客户端可以获取之
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
