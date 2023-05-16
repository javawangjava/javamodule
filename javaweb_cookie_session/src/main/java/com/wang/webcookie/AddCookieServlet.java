package com.wang.webcookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *
 * Cookie的基本使用,包含两部分内容:发送Cookie,获取Cookie。
 * 发送Cookie：
 *   1.创建Cookie对象，并设置数据：Cookie cookie = new Cookie("key","value");
 *   2.发送Cookie到客户端使用response对象：response.addCookie(cookie);
 *
 * */

@WebServlet("/addCookieServlet")
public class AddCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //发送Cookie
        //1. 创建Cookie对象，并设置数据：Cookie cookie = new Cookie("key","value");
        String name = "username";
        String value = "zhangsan";
        Cookie cookie = new Cookie(name, value);
        //Cookie cookie = new Cookie("username", "zhangsan");

        //2. 发送Cookie到客户端使用response对象：response.addCookie(cookie);
        resp.addCookie(cookie);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}

