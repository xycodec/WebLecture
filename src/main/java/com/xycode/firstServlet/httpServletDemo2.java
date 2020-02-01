package com.xycode.firstServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: httpServletDemo1
 *
 * @Author: xycode
 * @Date: 2020/1/14
 * @Description: this is description of the httpServletDemo1 class
 **/

@WebServlet(urlPatterns = "/httpDemo2",name = "httpDemo2")
public class httpServletDemo2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("HttpServlet is inited");
    }
    //对于继承HttpServlet,service这个方法一般不用重写,里面的逻辑已经被写好了,里面根据各种情况调用doXXX方法,我们只需重写doXXX方法即可
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//    }

    //HttpServlet中的doXXX方法,默认其实没做什么事情,只做了一个协议版本验证,我们的业务逻辑写在这里即可
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------------(httpServletDemo2)doGet--------------");
        ServletContext context=this.getServletContext();//ServletContext是全局的共享对象,可以被一个Servlet容器中的多个servlet实例共享
        //大概就是这样使用:(先访问httpDemo1后,设置好全局的Attribute后,这里就能获取,否则如果先访问httpDemo2,这里会返回null)
        System.out.println(context.getAttribute("global msg"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------------(httpServletDemo2)doPost-------------");
    }
}
