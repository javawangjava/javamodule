package com.wang.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */

/*
 *
 *       访问服务器资源时，需要先进行登录验证，如果没有登录，则自动跳转到登录页面.
 *           只需要写一个 Filter ，在该过滤器中进行登陆状态校验即可。而在该 Filter 中逻辑如下：
 *               0.判断访问的是否是登录相关资源
 *                   是：放行
 *                   不是：进行登录验证
 *               1.判断用户是否登录：session中是否有user对象
 *                   登录：直接放行
 *                   未登录：跳转到登录页面，并给出提示信息
 *
 *
 * LoginFilter 的过滤器中编写逻辑代码：
 *      在 doFilter() 方法中编写登陆状态校验的逻辑代码。
 *      我们首先需要从 session 对象中获取用户信息，但是 ServletRequest 类型的 requset 对象没有获取 session 对象的方法，所以此时需要将 request对象强转成
 * HttpServletRequest 对象。
 *      然后完成以下逻辑
 *          获取Session对象；
 *          从Session对象中获取名为 user 的数据；
 *          判断获取到的数据是否是 null；
 *              如果不是，说明已经登陆，放行；
 *              如果是，说明尚未登陆，将提示信息存储到域对象中并跳转到登陆页面；
 *
 *
 * */

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //判断访问资源路径是否和登录注册相关
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
        // 获取当前访问的资源路径
        String url = req.getRequestURL().toString();

        //循环判断
        for (String u : urls) {
            if(url.contains(u)){
                //找到了
                //放行
                chain.doFilter(request, response);
                //break;
                return;
            }
        }


        //1. 判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //2. 判断user是否为null
        if(user != null){
            // 登录过了
            //放行
            chain.doFilter(request, response);
        }else {
            // 没有登陆，存储提示信息，跳转到登录页面

            req.setAttribute("login_msg","您尚未登陆！");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }


    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }
    @Override
    public void destroy() {
    }


}



//// @WebFilter("/*") 拦截所有资源
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException
//            , IOException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        // 从这里截至for循环结束，表示放行访问的资源，用户要是需要登录或者注册的话就需要放行，放行登录或者注册需要的静态资源css和imgs
//        // 判断访问资源路径是否和登录注册相关
//        // 1,在数组中存储登陆和注册相关的资源路径，也就是设置放行的路径
//
//        //String[] urls = {"/login_register_jsp/login.jsp", "/imgs/", "/css/", "/loginServlet", "/login_register_jsp/register.jsp", "/registerServlet",
//        //        "/checkCodeServlet"};
//
//        String[] urls = {"/login.jsp","/imgs/","/css/","//loginServiceServlet","/register.jsp","/registerServiceServlet","/checkCodeServlet"};
//
//
//        // 2.获取当前访问的资源路径
//        String url = req.getRequestURL().toString();
//
//        //3,遍历数组，获取到每一个需要放行的资源路径
//        for (String u : urls) {
//            //4,判断当前访问的资源路径字符串是否包含要放行的的资源路径字符串
//                /*
//                比如当前访问的资源路径是 /brand-demo/login.jsp
//                而字符串 /brand-demo/login.jsp 包含了 字符串 /login.jsp ，所以这个字符串就需要放行
//                */
//            if (url.contains(u)) {
//                //找到了
//                //放行
//                chain.doFilter(request, response);
//                return;
//            }
//        }
//
//
//        // 后续就是访问了除登录和注册页面以外,css,imgs,以外的连接时要判断用户是否已经登录过了
//        //1. 判断session中是否有user
//        HttpSession session = req.getSession();
//        Object user = session.getAttribute("user");
//
//        //2. 判断user是否为null
//        if (user != null) {
//            // 登录过了
//            //放行
//            chain.doFilter(request, response);
//        } else {
//            // 没有登陆，存储提示信息，跳转到登录页面
//
//            req.setAttribute("login_msg", "您尚未登陆！");
//            req.getRequestDispatcher("/login.jsp").forward(req, response);
//        }
//
//    }
//
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//
//}
