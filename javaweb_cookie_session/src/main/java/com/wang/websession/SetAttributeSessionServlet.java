package com.wang.websession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 将数据存储到Session中：首先由请求对象获取Session对象，然后向Session对象中存储数据。
@WebServlet("/setAttributeSessionServlet")
public class SetAttributeSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //存储到Session中
        //1. 获取Session对象,使用的是request对象:HttpSession session = request.getSession();
        HttpSession session = req.getSession();
        System.out.println(session);// 打印Session对象

        //2. 存储数据到 session 域中:void setAttribute(String name, Object o);
        session.setAttribute("username","lisi");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
