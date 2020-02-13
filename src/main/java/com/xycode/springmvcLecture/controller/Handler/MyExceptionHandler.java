package com.xycode.springmvcLecture.controller.Handler;

import com.xycode.springmvcLecture.controller.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: MyExceptionHandler
 *
 * @Author: xycode
 * @Date: 2020/2/12
 * @Description: this is description of the MyExceptionHandler class
 **/
public class MyExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView=new ModelAndView();
        if(e instanceof MyException){
            e=(MyException)e;
            modelAndView.addObject("errorMsg",((MyException) e).getMyMsg());
        }else{
            modelAndView.addObject("errorMsg","其它异常信息");
        }
        modelAndView.setViewName("exception");//设置异常跳转的页面为exception.jsp
        return modelAndView;
    }
}
