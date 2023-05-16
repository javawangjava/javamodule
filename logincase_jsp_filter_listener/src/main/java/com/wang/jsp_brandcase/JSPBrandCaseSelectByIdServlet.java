package com.wang.jsp_brandcase;

import com.wang.pojo.Brand;
import com.wang.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*  JSPBrandSelectByIdServlet 的逻辑如下
*       1.获取请求数据 id；
*       2.调用 BrandService 的 selectById() 方法进行数据查询的业务逻辑；
*       3.将查询到的数据存储到 request 域对象中；
*       4.跳转到 update.jsp 页面进行数据真实；
* */

@WebServlet("/jSPBrandCaseSelectByIdServlet")
public class JSPBrandCaseSelectByIdServlet extends HttpServlet {
    private  BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        //2. 调用service查询
        Brand brand = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("brand",brand);

        //4. 转发到update.jsp
        request.getRequestDispatcher("/brandcasejsp/brandcaseUpdateBrand.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}