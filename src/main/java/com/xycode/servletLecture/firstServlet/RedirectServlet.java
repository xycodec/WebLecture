package com.xycode.servletLecture.firstServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: RedirectServlet
 *
 * @Author: xycode
 * @Date: 2020/1/20
 * @Description: this is description of the RedirectServlet class
 **/
@WebServlet(urlPatterns = "/redirectDemo")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RedirectServlet(Post)...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RedirectServlet(Get)...");
//        resp.setStatus(302);//重定向的状态码
//        resp.setHeader("location","/webLecture/httpDemo1");//location是重定向字段
        resp.sendRedirect("/webLecture/httpDemo1");

    }
}
