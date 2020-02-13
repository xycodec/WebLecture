<%--
  Created by IntelliJ IDEA.
  User: xycode
  Date: 2020/1/14
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>webLecture</title>
  </head>
  <body>
    <h3>
      hello, this is springmvc
    </h3>
<%--    这里的超链接指向Hello类中@RequestMapping(path = "/hello")指定的方法sayHello()--%>
<%--    warn: 这里写"/hello"似乎会出错,导致springmvc无法转到sayHello()方法--%>
    <a href="hello?username=xycode">0 入门程序: hello</a> <br/>
    <a href="param/testParam1?username=xycode&password=pass">1.1 请求参数绑定:testParam1</a>

<%--    JSP映射参数的方式--%>
    <h4>1.2 请求参数绑定:testParam2</h4>
    <form action="param/testParam2" method="post">
        姓名: <input type="text" name="username"/> <br/>
        密码: <input type="text" name="password"/> <br/>
        金额: <input type="text" name="money"/> <br/>

<%--    集合类型的参数绑定,warn: 以内部类定义InternalInformation的话会出错,需要独立出来--%>
        <h5 style="color: cadetblue; font-weight: lighter">集合类型的参数绑定:</h5>
        内部信息(list:id): <input type="text" name="list[0].id"/> <br/>
        内部信息(list:level): <input type="text" name="list[0].level"/> <br/>
        内部信息(map:id): <input type="text" name="map['one'].id"/> <br/>
        内部信息(map:level): <input type="text" name="map['one'].level"/> <br/>
        <input type="submit" value="提交"/>
    </form>
    <a href="param/testServlet">1.3 获取原生Servlet</a> <br/><br/>

    <a href="anno/testAnno1">1.4.1 注解方式约束参数(RequestParam)</a> <br/>
    <a href="anno/testAnno2/1234">1.4.2 注解方式约束参数(PathVariable)</a> <br/><br/>

    <a href="response/testResponse1">1.5.1 获取全局共享数据(user)</a> <br/>
    <a href="response/testForward1">1.5.2 原生Servlet转发请求,跳过页面解析器</a> <br/>
    <a href="response/testForward2">1.5.3 forward字段转发请求,跳过页面解析器</a> <br/><br/>

    <a href="exception/testException1">1.6.1 异常处理器</a> <br/><br/>

    <a href="interceptor/testInterceptor1">1.7.1 拦截器</a> <br/>
  </body>
</html>
