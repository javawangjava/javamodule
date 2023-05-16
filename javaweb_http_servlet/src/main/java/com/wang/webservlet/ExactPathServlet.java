package com.wang.webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//urlPattern精确匹配，直接指明
//2.1.精确匹配；配置路径：  @WebServlet("/exactPathServlet")
// 访问路径：http://localhost/javaweb_http_servlet/exactPathServlet

@WebServlet("/exactPathServlet")
//@WebServlet("/servlet/exactPathServlet")
public class ExactPathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ExactPathServlet....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}

