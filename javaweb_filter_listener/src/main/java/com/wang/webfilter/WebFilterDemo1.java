//package com.wang.webfilter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//
//@WebFilter("/*")
//public class WebFilterDemo1 implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //放行前，对 servletRequest数据进行处理
//        System.out.println("1. WebFilterDemo1：放行前，对servletRequest数据进行处理");
//        //就是放行，也就是让其访问本该访问的资源
//        filterChain.doFilter(servletRequest,servletResponse);
//        //放行后，对servletResponse 数据进行处理
//        System.out.println("5.WebFilterDemo1：放行后，对servletResponse反应数据进行处理");
//    }
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//
//    @Override
//    public void destroy() {
//    }
//
//}
