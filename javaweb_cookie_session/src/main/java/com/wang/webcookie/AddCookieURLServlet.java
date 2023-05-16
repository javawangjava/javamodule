package com.wang.webcookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/*
 *
 * Cookie的基本使用,包含两部分内容:发送Cookie,获取Cookie。
 * 发送Cookie：
 *   1.创建Cookie对象，并设置数据：Cookie cookie = new Cookie("key","value");
 *   2.发送Cookie到客户端使用response对象：response.addCookie(cookie);
 *
 * Cookie的使用细节：
 *       注意：浏览器关闭再打开不是指打开一个新的选显卡，而且必须是先关闭再打开，顺序不能变。
 *       Cookie的存活时间:
 *           1.默认情况下，Cookie存储在浏览器内存中，当浏览器关闭，内存释放，则Cookie被销毁；
 *       Cookie持久化存储：
 *           1.设置Cookie存活时间：setMaxAge(int seconds)
 *               参数值(int seconds)为:
 *                   1.正数：将Cookie写入浏览器所在电脑的硬盘，持久化存储。到时间自动删除；
 *                   2.负数：默认值，Cookie在当前浏览器内存中，当浏览器关闭，则Cookie被销毁；
 *                   3.零：删除对应Cookie【即默认情况，Cookie存储在浏览器内存中，当浏览器关闭，内存释放，则Cookie被销毁】；
 *
 * */


@WebServlet("/addCookieURLServlet")
public class AddCookieURLServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //发送Cookie：Cookie中保存中文，在发送Cookie之前先对中文进行URL编码，
        String name = "username";
        String value = "张三";

        //对中文进行URL编码
        value= URLEncoder.encode(value,"UTF-8");
        System.out.println("存储数据value："+value);

        //将编码后的值存入Cookie中
        Cookie cookie = new Cookie(name, value);

        //设置Cookie存活时间：setMaxAge(int seconds) 1周 7天
        cookie.setMaxAge(60 * 60 * 24 * 7);

        //发送Cookie到客户端使用response对象：response.addCookie(cookie);
        resp.addCookie(cookie);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
