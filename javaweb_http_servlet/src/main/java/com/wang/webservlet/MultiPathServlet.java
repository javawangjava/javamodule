package com.wang.webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//一个Servlet,可以配置多个urlPattern,多个地址使用数组表示；@WebServlet(urlPatterns ={"/multiPathServletPath1", "/multiPathServletPath2"} )

//@WebServlet(urlPatterns = {"/multiPathServletPath1", "/multiPathServletPath2"})
@WebServlet(urlPatterns = {"/multiPathServlet/path1", "/multiPathServlet/path2"})
public class MultiPathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MultiPathServlet....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
