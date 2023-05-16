package com.wang.web.jspbrandweb;

import com.wang.pojo.Brand;
import com.wang.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 在该修改页面我们可以看到将 编辑 按钮所在行的数据 回显 到表单，然后需要修改那个数据在表单中进行修改，然后点击 提交 的按钮将数据提交到后端，后端再将数据存储到数据库中。
* 修改 功能需要从两方面进行实现，数据回显和修改操作。
*
* 要实现这个效果，那当点击 修改 按钮时不能直接跳转到 update.jsp 页面，而是需要先带着当前行数据的 id 请求后端程序，
* 后端程序根据 id 查询数据，将数据存储到域对象中跳转到 update.jsp 页面进行数据展示。
*
*  JSPBrandSelectByIdServlet 的逻辑如下
*       1.设置处理post请求乱码的字符集；
*       2.接收客户端提交的数据；
*       3.将接收到的数据封装到 Brand 对象中；
*       4.调用 BrandService 的 update() 方法进行添加的业务逻辑处理；
*       5.跳转到 selectAllServlet 资源重新查询数据；
*
* */

@WebServlet("/jSPBrandUpdateServlet")
public class JSPBrandUpdateServlet extends HttpServlet {
    private BrandService service = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));


        //2. 调用service 完成修改
        service.update(brand);


        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/jSPBrandSelectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}