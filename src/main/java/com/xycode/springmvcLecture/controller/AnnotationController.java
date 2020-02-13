package com.xycode.springmvcLecture.controller;

import com.xycode.springmvcLecture.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: ParamController
 *
 * @Author: xycode
 * @Date: 2020/2/11
 * @Description: this is description of the ParamController class
 **/
//tip: 使用注解方式
@Controller
@RequestMapping("/anno")
public class AnnotationController {
    //参数列表会自动与提交链接匹配key,以此获得对应的value
    //约束请求传一个username参数,注意这里使用name或者value,这两个是一回事儿
    //使用defaultValue后,username就不是必须传了,它提供了一个默认值
    @RequestMapping("/testAnno1")
    public String testAnno1(@RequestParam(name = "username",defaultValue="徐岩")String username){
        System.out.println("------------testAnno1-------------");
        System.out.println(username);
        return "success";
    }

    //PathVariable注解用于提取REST风格路径中的值,这里就是{id},name属性用于提取指定名字的值
    @RequestMapping(value = "/testAnno2/{id}",method = RequestMethod.GET)
    public String testAnno2(@PathVariable(name = "id") String id){
        System.out.println("------------testAnno2-------------");
        System.out.println("id="+id);
        return "success";
    }
}
