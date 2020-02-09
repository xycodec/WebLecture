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

@WebServlet(urlPatterns = "/cookieDemo2")
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取已存在的cookie
        //tip: 因为cookie本质上是一种客户端缓存技术,所以已缓存的cookie是需要从客户端得到,而客户端对应的就是request
        Cookie[] cookies=req.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                System.out.println(cookie.getName()+" : "+cookie.getValue()+",maxAge="+cookie.getMaxAge());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
