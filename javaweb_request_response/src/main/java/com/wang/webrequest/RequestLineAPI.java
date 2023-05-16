package com.wang.webrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
 *     Request获取请求行数据
 *     使用Request对象来获取请求行的API方法【这些方法是POST请求和GET请求共有的，除了String getQueryString()】：
 *               1.String getMethod()：获取请求方式；
 *               2.String getContextPath()：获取虚拟目录(项目访问路径)；
 *               3.StringBuffer getRequestURL()：获取URL(统一资源定位符)；
 *               4.String getRequestURI()：获取URI(统一资源标识符)；
 *               5.String getQueryString()：GET请求获取请求参数【这一个方法仅用于GET请求，因为GET请求的参数在请求行中】
 *               【String getQueryString()： Returns the query string that is contained in the request URL after the path】
* */


/*
 * Request获取请求行数据程序示例：
 *   getRequestLine.html；postRequestLine.html
 *  【GET请求示例1】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/requestLineAPI?username=zhangsan&password=123 ；
 *  【GET请求示例2】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/getRequestLine.html
 *  【POST请求示例】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/postRequestLine.html
 * */


// 在类上使用@WebServlet 注解，配置该 Servlet的访问路径
@WebServlet("/requestLineAPI")
public class RequestLineAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // String getMethod()：获取请求方式：
        String method = req.getMethod();
        System.out.println("req.getMethod():"+method);

        // String getContextPath()：获取虚拟目录(项目访问路径)：
        String contextPath = req.getContextPath();
        System.out.println("req.getContextPath():"+contextPath);

        // StringBuffer getRequestURL(): 获取URL(统一资源定位符)：
        StringBuffer url = req.getRequestURL();
        System.out.println("req.getRequestURL():"+url.toString());

        // String getRequestURI()：获取URI(统一资源标识符)：
        String uri = req.getRequestURI();
        System.out.println("req.getRequestURI():"+uri);

        // String getQueryString()：GET方式请求获取请求参数；后面对于获取请求参数会统一处理
        String queryString = req.getQueryString();
        System.out.println("req.getQueryString():"+queryString);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 因为String getQueryString()是GET方式请求获取请求参数，所以下面没有选;这里也没有采用简化代码调用doGet()方法的措施

        // String getMethod()：获取请求方式：
        String method = req.getMethod();
        System.out.println("req.getMethod():"+method);

        // String getContextPath()：获取虚拟目录(项目访问路径)：
        String contextPath = req.getContextPath();
        System.out.println("req.getContextPath():"+contextPath);

        // StringBuffer getRequestURL(): 获取URL(统一资源定位符)：
        StringBuffer url = req.getRequestURL();
        System.out.println("req.getRequestURL():"+url.toString());

        // String getRequestURI()：获取URI(统一资源标识符)：
        String uri = req.getRequestURI();
        System.out.println("req.getRequestURI():"+uri);
    }

}

// 以GET请求为例
// http://localhost/javaweb_request_response/requestLineAPI?username=zhangsan&passwrod=123为例，输出结果
// req.getMethod():GET
// req.getContextPath():/javaweb_request_response
// req.getRequestURL():http://localhost/javaweb_request_response/requestLineAPI
// req.getRequestURI():/javaweb_request_response/requestLineAPI
// req.getQueryString():username=zhangsan&passwrod=123