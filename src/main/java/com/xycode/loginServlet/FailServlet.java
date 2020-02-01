package com.xycode.loginServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: FailServlet
 *
 * @Author: xycode
 * @Date: 2020/1/19
 * @Description: 登录失败的页面处理Servlet
 **/
@WebServlet(urlPatterns = "/failServlet")
public class FailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("----------(FailServlet)doGet----------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("登录失败");
    }
}
