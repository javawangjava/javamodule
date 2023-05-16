package com.wang.webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//urlPattern目录匹配:该一级目录下的二级目录是任意的都可以访问
// 2.2.目录匹配；配置路径：@WebServlet("/servlet/*")
//     访问路径：
//     http://localhost/javaweb_http_servlet/servlet/*
//     http://localhost/javaweb_http_servlet/servlet/123
//     http://localhost/javaweb_http_servlet/servlet/456

@WebServlet("/servlet/*")
public class DirectoryPathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DirectoryPathServlet....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}

