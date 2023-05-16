package com.wang.web;

import com.alibaba.fastjson.JSON;
import com.wang.pojo.Brand;
import com.wang.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/*
*
*  将查询到的集合数据转换为 json 数据。我们将此过程称为 序列化；如果是将 json 数据转换为 Java 对象，我们称之为反序列化。
*  将 json 数据响应回给浏览器。这里一定要设置响应数据的类型及字符集response.setContentType("text/json;charset=utf-8");
*
* */

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用Service查询
        List<Brand> brands = brandService.selectAll();

        //2. 将集合转换为JSON数据   序列化
        String jsonString = JSON.toJSONString(brands);

        //3. 响应数据  application/json text/json
        //  response.setContentType("text/json;charset=utf-8");设置响应数据的格式和字符编码
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}