package com.xycode.springmvcLecture.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: MyInterceptor
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the MyInterceptor class
 **/
//自定义的拦截器
public class MyInterceptor implements HandlerInterceptor {
    //拦截前处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("----------------MyInterceptor(preHandle)------------------");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return true;//返回true的话表示继续将请求传递到下一个拦截器,返回false則反之
    }

    //拦截后处理(但在DispatcherServlet渲染视图之前调用)
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("----------------MyInterceptor(postHandle)------------------");
    }

    //DispatcherServlet渲染视图之后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("----------------MyInterceptor(afterCompletion)------------------");
    }


    /*
        拦截器的几个方法的处理流程:
            前提是在请求没有被转发/重定向
                顺序是: preHandle --> (requestController) --> postHandle --> (页面渲染) --> afterCompletion

        以上的输出是:
                ----------------MyInterceptor(preHandle)------------------
                ----------------testInterceptor1--------------------
                ----------------MyInterceptor(postHandle)------------------
                渲染error.jsp成功
                ----------------MyInterceptor(afterCompletion)------------------
     */
}
