package com.wang.web;

import com.alibaba.fastjson.JSON;
import com.wang.pojo.Brand;
import com.wang.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
/*
* 如上所示，当我们点击 新增 按钮，会跳转到 addBrand.html 页面。在 addBrand.html 页面输入数据后点击 提交 按钮，就会将数据提交到后端，而后端将数据保存到数据库中。
*   具体的逻辑如下：
*       1.获取请求参数
*           由于前端提交的是 json 格式的数据，所以我们不能使用 request.getParameter() 方法获取请求参数
*               如果提交的数据格式是 username=zhangsan&age=23 ，后端就可以使用 request.getParameter() 方法获取
*               如果提交的数据格式是 json，后端就需要通过 request 对象获取输入流，再通过输入流读取数据
*       2.将获取到的请求参数（json格式的数据）转换为 Brand 对象
*       3.调用 service 的 add() 方法进行添加数据的逻辑处理
*       4.将 json 数据响应回给浏览器。
*
*
* */

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收数据,request.getParameter 不能接收json的数据
       /* String brandName = request.getParameter("brandName");
        System.out.println(brandName);*/

        // 获取请求体数据 如果提交的数据格式是 json，后端就需要通过 request 对象获取输入流，再通过输入流读取数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        // 将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);


        //2. 调用service 添加
        brandService.add(brand);

        //3. 响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}