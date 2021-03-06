package com.xycode.servletLecture.firstServlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * ClassName: servlet
 *
 * @Author: xycode
 * @Date: 2020/1/14
 * @Description: this is description of the servlet class
 **/
public class servletDemo1 implements Servlet {

    //init方法默认被客户端第一次请求时触发,并且只运行一次
    //可以通过在web.xml中配置load-on-startup字段来指定
    //1.指定<load-on-startup>的值为负数,表示第一次被访问时触发,
    //2.指定<load-on-startup>的值大于等于0,表示在服务器启动时触发,
    //load-on-startup的值大于等于0时, 实际上就是优先级,数值越大优先级越低,0的优先级最高,多个servlet可以设置不同的优先级
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet is inited");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service()是主要的业务逻辑方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //destroy()一般用于释放资源
    @Override
    public void destroy() {
        System.out.println("servlet is destroyed");
    }
}
