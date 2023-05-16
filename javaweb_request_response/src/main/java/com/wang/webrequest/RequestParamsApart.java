package com.wang.webrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


/*
 *  没有对参数获取统一方式之前，对于请求参数的获取,常用的有以下两种:两种请求获取参数的方式不统一
 *           1.获取GET方式请求参数：String getQueryString()；
 *           2.获取POST方式请求参数：BufferedReader getReader()和ServletInputStream getInputStream()；
 *
 *  实现一个案例需求:
 *       （1）发送一个GET请求并携带用户名，后台接收后打印到控制台;
 *       （2）发送一个POST请求并携带用户名，后台接收后打印到控制台;
 *
 * */


@WebServlet("/requestParamsApart")
public class RequestParamsApart extends HttpServlet {

 /*
    // 由于获取请求参数的方式不一样，导致doGet()和doPost()中出现了重复代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = req.getQueryString();
        // 由于获取请求参数的方式不一样，导致doGet()和doPost()中出现了重复代码，下面这一行代码可以理解为很多相同的业务代码
        System.out.println(params);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        System.out.println(params);
    }
    */




    /*

    // GET请求方式和POST请求方式区别主要在于获取请求参数的方式不一样，通过判断请求方式来区分从而简化代码。
    // 对于doGet()和doPost()中出现了重复代码的解决方案1：
    // 使用request的getMethod()来获取请求方式，根据请求方式的不同分别获取请求参数值，这样就可以解决上述问题，但是以后每个Servlet都需要这样写代码，实现起来比较麻烦，这种方案我们不采用.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求方式
        String method = req.getMethod();
        // 获取请求参数
        String params = "";
        // 对请求方式进行判断，从而选取相应的获取请求参数的方式
        if ("GET".equals(method)) {
            params = req.getQueryString();
        } else if ("POST".equals(method)) {
            BufferedReader reader = req.getReader();
            params = reader.readLine();
        }
        // 相同的业务代码，将请求参数打印至控制台
        System.out.println(params);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    */





    //  对于doGet()和doPost()中出现了重复代码的解决方案2：
    //  request对象已经将上述获取请求参数的方法进行了封装，并且request提供的方法实现的功能更强大，以后只需要调用request提供的方法即可

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }


}
