package com.xycode.springmvcLecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: Hello
 *
 * @Author: xycode
 * @Date: 2020/2/11
 * @Description: this is description of the Hello class
 **/

//Controller类,作用相当于Servlet
@Controller
//在类上使用RequestMapping注解,其指定的path会成为父路径,
// 例如对于sayHello()来说,其外部的路径就变成了user/hello,在外部使用经常是作为一个模块路径使用的.
//@RequestMapping(path = "/user")
public class Hello {
    //映射该函数为指定请求路径的处理器
    //params: 指定访问所需的参数,下例就是/hello?username=xycode
    //method:　指定请求类型
    @RequestMapping(path = "/hello",params = {"username=xycode"},method = RequestMethod.GET)
    public String sayHello(String username){//要想获得username,就直接在方法中指定对应参数即可
        System.out.println(username+", SpringMVC Hello");
        return "success";//spring框架会根据返回的success字符串去指定目录下加载名为success的页面文件(这里就是success.jsp)
    }
}
