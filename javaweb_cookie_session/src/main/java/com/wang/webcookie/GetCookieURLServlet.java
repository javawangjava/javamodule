package com.wang.webcookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/*
 *
 * 获取Cookie：
 *   1.获取客户端携带的所有Cookie，使用request对象：Cookie[] cookies = request.getCookies();;
 *   2.遍历数组，获取每一个Cookie对象：for;
 *   3.使用Cookie对象方法获取数据:cookie.getName(),cookie.getValue();
 *
 *
 * */


@WebServlet("/getCookieURLServlet")
public class GetCookieURLServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取Cookie
        // 1. 获取客户端携带的所有Cookie，返回值是数组，使用request对象
        Cookie[] cookies = req.getCookies();
        // 2. 遍历数组，获取每一个Cookie对象
        for (Cookie cookie : cookies) {
            // 3. 使用Cookie对象方法获取数据:cookie.getName(),cookie.getValue()
            String name = cookie.getName();
            // 下面这时就是找一个Cookie的键为字符串"username"。
            if("username".equals(name)){
                String value = cookie.getValue();// 获取的是URL编码后的值
                //URL解码
                value = URLDecoder.decode(value,"UTF-8");
                System.out.println(name+":"+value);
                break;
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
