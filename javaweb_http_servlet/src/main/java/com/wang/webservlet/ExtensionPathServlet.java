package com.wang.webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//2.3.扩展名匹配；配置路径：@Webservlet("*.do")
//     访问路径：
//     http://localhost/javaweb_http_servlet/aaa.do
//     http://localhost/javaweb_http_servlet/bbb.do
@WebServlet("*.do")
public class ExtensionPathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ExtensionPathServlet....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
