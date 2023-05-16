package com.wang.webresponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
 *
 *   Response响应字符数据：
 *       一次请求响应结束后，response对象就会被销毁掉，所以不要手动关闭流。
 *
 *       将字符数据写回到浏览器，我们需要两个步骤：
 *       【步骤一】：设置响应的数据格式及数据的编码：response.setContentType("text/html;charset=UTF-8");void setContentType(String type)
 * :设置Response对象返回到客户端的内容形式。
 *       【步骤二】：通过Response对象获取字符输出流： PrintWriter writer = resp.getWriter();
 *       【步骤三】：通过字符输出流写数据: writer.write("aaa");
 *
 * */


@WebServlet("/ResponseWriterServlet")
public class ResponseWriterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        // 设置响应的数据格式及数据的编码
        //void setContentType(String type):设置Response对象返回到客户端的内容形式。
        response.setContentType("text/html;charset=UTF-8");

        // 示例1：
        // 获取字符输出流
        PrintWriter writer = response.getWriter();
        // 通过字符输出流写数据
        writer.write("平凡的世界");

        // 示例2：设置response对象返回到客户端的数据为text/html，编码规则为UTF-8

        // 通过字符输出流写数据
        writer.write("<h1>平凡的世界</h1>");
        writer.write("平凡的世界");


        //  示例3：设置response对象返回到客户端的数据是 HTML类型数据，
        //  content-type，告诉浏览器返回的数据类型是HTML类型数据，这样浏览器才会解析HTML标签
        response.setHeader("content-type", "text/html");
        writer.write("<h1>你好，初次见面</h1>");
        writer.write("你好，初次见面");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
