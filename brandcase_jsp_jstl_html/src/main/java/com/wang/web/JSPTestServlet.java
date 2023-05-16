package com.wang.web;

import com.wang.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
// 对应webapp中brandjsp
@WebServlet("/jSPTestServlet")
public class JSPTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 准备数据
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));

        //2. 存储到request域中
        request.setAttribute("brands",brands);

        //3. 转发到 el-brandcaseBrand.jsp
        //request.getRequestDispatcher("/brandjsp/el-brandcaseBrand.jsp").forward(request,response);
        request.getRequestDispatcher("/brandjsp/el-brand2.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}