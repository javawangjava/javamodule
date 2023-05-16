package com.wang.webrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


// 【获取Request请求体数据】：获取请求体是针对POST请求的。
//      浏览器在发送GET请求的时候是没有请求体的；浏览器在发送POST请求的时候是有请求体的；
//      使用Request对象来获取POST请求的请求体的API方法：
//           1.ServletInputStream getInputStream()：获取字节输入流【适合前端发送的是字节数据，字符数据也可以只不过字符数据要指定编码格式】
//           2.BufferedReader getReader()：获取字符输入流【适合前端发送的是纯文本数据】
//


/*
 * Request获取请求体数据程序示例：
 *  对应的html文件：getRequestBody.html；postRequestBody.html
 *
 *  【GET请求示例1】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/postRequestBodyAPI?username=zhangsan&password=123 ；
 *  【GET请求示例2】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/getRequestBody.html
 *  【POST请求示例】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/postRequestBody.html
 * */


@WebServlet("/postRequestBodyAPI")
public class PostRequestBodyAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // BufferedReader流是通过request对象来获取的，当请求完成后request对象就会被销毁，request对象被销毁后，BufferedReader流就会自动关闭，所以此处就不需要手动关闭流了。

        // 在Servlet的doPost方法中使用request的getReader()或者getInputStream()来获取POST请求的请求体数据；
        // 获取 post 请求体：请求参数
        //1. 获取字符输入流 ，BufferedReader流是通过request对象来获取的，当请求完成后request对象就会被销毁，request对象被销毁后，BufferedReader
        // 流就会自动关闭，所以此处就不需要手动关闭流了。
        BufferedReader br = req.getReader();
        //2. 读取数据
        String line = br.readLine();
        System.out.println(line);

    }

}

