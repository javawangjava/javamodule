package com.wang.web.jspbrandweb;

import com.wang.pojo.Brand;
import com.wang.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/*
*   JSPBrandSelectAllServlet 的逻辑如下
*       1.调用 BrandService 的 selectAll() 方法进行业务逻辑处理，并接收返回的结果;
*       2.将上一步返回的结果存储到 request 域对象中;
*       3.跳转到 brand.jsp 页面进行数据的展示;
* */

@WebServlet("/jSPBrandSelectAllServlet")
public class JSPBrandSelectAllServlet extends HttpServlet {
    private  BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 调用BrandService完成查询
        List<Brand> brands = service.selectAll();

        //2. 存入request域中
        request.setAttribute("brands",brands);

        //3. 转发到brand.jsp
        request.getRequestDispatcher("/brandcasejsp/brandcaseBrand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}