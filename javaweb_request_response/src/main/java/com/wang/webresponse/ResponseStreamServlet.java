package com.wang.webresponse;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 响应字节数据：设置字节数据的响应体
 *   Response响应字节数据：
 *       一次请求响应结束后，response对象就会被销毁掉，所以不要手动关闭字符输出流。
 *       void setContentType(String type):设置Response对象返回到客户端的内容形式。
 *       将字节数据写回到浏览器，我们需要两个步骤：
 *       【步骤一】：字符输入流读取文件；FileInputStream fis = new FileInputStream("d://小学英语语法思维导图（1图）.pdf");
 *       【步骤二】：通过Response对象获取字节输出流：ServletOutputStream outputStream =resp.getOutputStream();
 *       【步骤三】：通过字节输出流写数据: outputStream.write(字节数据)。这里拷贝的过程可以调用工具类【IOUtils.copy(fis,os);fis:输入流；os:输出流】或者字节写拷贝方式。
 *       【步骤四】：完成字符输出，需要再方法结束的时候关闭字节输入流【字节输入流是自己开启的】;
 * */

@WebServlet("/responseStreamServlet")
public class ResponseStreamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    /*
        // Response响应字符数据方式1：
        //    1.读取文件
        FileInputStream fis = new FileInputStream("d://小学英语语法思维导图（1图）.pdf");
        //    2.获取response字节输出流
        ServletOutputStream os = response.getOutputStream();
        //  3.完成流的copy
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            os.write(buff, 0, len);
        }
        // 4.关闭字节输入流
        fis.close();
        */

        // Response响应字符数据方式2：
        // 1.字符输入流读取文件
        FileInputStream fis = new FileInputStream("d://小学英语语法思维导图（1图）.pdf");
        // 2.获取response字节输出流
        ServletOutputStream os = response.getOutputStream();
        // 3.完成流的copy
        //   IOUtils.copy(fis,os);fis:输入流；os:输出流
        IOUtils.copy(fis, os);
        // 4.关闭字节输入流
        fis.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
