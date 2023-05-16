package com.wang.webresponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*
*
* *   Respones请求重定向：Response重定向(redirect):一种资源跳转方式。
 *               (1)浏览器发送请求给服务器，服务器中对应的资源A接收到请求；
 *               (2)资源A现在无法处理该请求，就会给浏览器响应一个302的状态码+location的一个访问资源B的路径；
 *               (3)浏览器接收到响应状态码为302就会重新发送请求到location对应的访问地址去访问资源B；
 *               (4)资源B接收到请求后进行处理并最终给浏览器响应结果，这整个过程就叫重定向。
 *
 * *       void sendRedirect(String location):Response对象的重定向方法。
 *         重定向的实现方式：
 *              实现重定向方式1：
 *                   resp.setStatus(302);// 设置状态码302
 *                   resp.setHeader("location","资源B的访问路径");//设置响应头
 *
 *              实现重定向方式2：
 *                   resp.sendRedirect("资源B的访问路径");// 重定向
*
*               实现重定向方式3：动态获取虚拟目录
 *                   String contextPath=req.getContextPath();
 *                   resp.sendRedirect(contextPath+"资源B的访问路径");// 重定向
* */


@WebServlet("/responseRedirectServlet")
public class ResponseRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        System.out.println("ResponseRedirectServlet");

      /*
        // 重定向实现方式1：先设置响应码，然后再设置响应头。
        // 1.设置响应状态码  302
        response.setStatus(302);
        // 2.设置响应头  Location  注意这里Location包含了项目路径
        response.setHeader("Location", "/javaweb_request_response/responseRedirect2Servlet");
       */

        /*
        // 重定向实现方式2：先设置响应码，然后再设置响应头。
        response.sendRedirect("/javaweb_request_response/responseRedirect2Servlet");
        */


        // 重定向实现方式3:动态获取虚拟目录:实现动态重定向
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/responseRedirect2Servlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
