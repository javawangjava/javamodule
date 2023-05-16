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
*
* 添加功能流程：
*   点击 新增 按钮后，会先跳转到 addBrand.jsp 新增页面，在该页面输入要添加的数据，输入完毕后点击 提交 按钮，需要将数据提交到后端，而后端进行数据添加操作，并重新将所有的数据查询出来。
*
* JSPBrandAddServlet逻辑如下
*       1.设置处理post请求乱码的字符集
*       2.接收客户端提交的数据
*       3.将接收到的数据封装到 Brand 对象中
*       4.调用 BrandService 的 add() 方法进行添加的业务逻辑处理
*       5.跳转到 selectAllServlet 资源重新查询数据
*
* */

@WebServlet("/jSPBrandCaseAddServlet")
public class JSPBrandCaseAddServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个Brand对象
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));


        //2. 调用service 完成添加
        service.add(brand);


        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/jSPBrandCaseSelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}