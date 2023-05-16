package com.wang.webrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// Request获取请求头数据：
//      请求头Request Headers的数据格式是键值对的形式： key:value； 例如：Host: localhost；Accept-Language: zh-CN,zh;q=0.9。
//      String getHeader(String name):形参name是请求头Request Headers中的的变量名。想获取那一个键值对的值那么那个键值对的键就作为getHeader()的形参。


/*
 *
 * Request获取请求头数据程序示例：
 *   getRequestHeader.html；postRequestHeader.html
 *  【GET请求示例1】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/requestHeaderAPI?username=zhangsan&password=123 ；
 *  【GET请求示例2】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/getRequestHeader.html
 *  【POST请求示例】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/postRequestHeader.html
 *
 * */


@WebServlet("/requestHeaderAPI")
public class RequestHeaderAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求头数据: User-Agent: 浏览器的版本信息
        String userAgent = req.getHeader("User-Agent");
        System.out.println("userAgent:" + userAgent);

        // 获取请求头数据：Accept-Language:浏览器可以访问的语言
        String acceptLanguage = req.getHeader("Accept-Language");
        System.out.println("acceptLanguage:" + acceptLanguage);

        // 获取请求头数据：Cookie:
        String cookie = req.getHeader("Cookie");
        System.out.println("cookie:" + cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 因为POST请求的一些方法和GET请求是相同的，对于两者相同的方法，这里才员工调用本类的doGet()方法来简化代码
        this.doGet(req, resp);
    }

}
