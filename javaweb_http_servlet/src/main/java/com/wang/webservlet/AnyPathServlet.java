package com.wang.webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 2.4.任意匹配:
//     配置路径：
//          @Webservlet("/")；@WebServlet("/*")
//     访问路径：
//        http://localhost/javaweb_http_servlet/hehe
//        http://localhost/javaweb_http_servlet/haha
//     注意: 任意匹配路径的/ 和 /* 的区别?
//     1. 当我们的项目中的Servlet配置了 "/",会覆盖掉tomcat中的DefaultServlet,当其他的url-pattern都匹配不上时都会走这个Servlet。
//     2. 当我们的项目中配置了"/*",意味着匹配任意访问路径。
//     3. DefaultServlet是用来处理静态资源，如果配置了"/"会把默认的覆盖掉，就会引发请求静态资源的时候没有走默认的而是走了自定义的Servlet 类，最终导致静态资源不能被访问。

@WebServlet("/")
//@WebServlet("/*")
public class AnyPathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AnyPathServlet....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}