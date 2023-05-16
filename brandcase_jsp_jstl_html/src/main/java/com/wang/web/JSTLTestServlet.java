package com.wang.web;

import com.wang.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
*
* 定义servlet，在 servlet 中封装一些数据并存储到 request 域对象中并转发到 el-brandcaseBrand.jsp 页面。
*   注意： 此处需要用转发，因为转发才可以使用 request 对象作为域对象进行数据共享。
* 在 el-brandcaseBrand.jsp 中通过 EL表达式 获取数据。
*
* */

@WebServlet("/jSTLTestServlet")
public class JSTLTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 存储到request域中
        request.setAttribute("status",1);

        //2. 转发到 el-brandcaseBrand.jsp
        //request.getRequestDispatcher("/brandjstl/jstl-if.jsp").forward(request,response);
        request.getRequestDispatcher("/brandjstl/jstl-foreach.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}