package com.wang.websession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//从Session中获取数据：首先由请求对象获取Session对象，然后从Session对象中获取数据。
@WebServlet("/getAttributeSessionServlet")
public class GetAttributeSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从Session中获取数据
        //1. 获取Session对象,使用的是request对象:HttpSession session = request.getSession();
        HttpSession session = req.getSession();
        System.out.println(session);// 打印Session对象

        //2.  根据 key，获取值:Object getAttribute(String name);
        Object username = session.getAttribute("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
