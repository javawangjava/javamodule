package com.wang.webrequest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


/*
* Request请求转发
 *
 * Request请求转发:请求转发(forward):一种在服务器内部的资源跳转方式。
 *           (1)浏览器发送请求给服务器，服务器中对应的资源A接收到请求;
 *           (2)资源A处理完请求后将请求发给资源B;
 *           (3)资源B处理完后将结果响应给浏览器;
 *           (4)请求从资源A到资源B的过程就叫请求转发。
 *
 *       Request对象请求转发的实现方式:req.getRequestDispatcher("资源B路径").forward(req,resp);
 *       请求转发资源间共享数据:使用Request对象提供的三个方法
 *           void setAttribute(String name,Object o)：将属性【键值对形式的数据 name:o】存储数据到request域[范围,数据是存储在request对象]中；
 *           Object getAttribute(String name)：根据属性的键key获取属性的值；
 *           void removeAttribute(String name)：根据key删除该键值对；
 *
 *      属性Attribute：键：值；声明变量并同时赋值。成对存在。
 *
* */

@WebServlet("/requestDispatcherServlet")
public class RequestDispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        System.out.println("requestDispatcherServlet");
        // void setAttribute(String name,Object obj)：存储数据到request域[范围,数据是存储在request对象]中；
        // 存储数据：将键值对形式的数据【属性name：obj】保存在当前对象request中
        request.setAttribute("msg","helloworld");

        // 将request请求转发至资源B路径  Request对象请求转发的实现方式:req.getRequestDispatcher("资源B路径").forward(req,resp);
        request.getRequestDispatcher("/requestDispatcher2Servlet").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
