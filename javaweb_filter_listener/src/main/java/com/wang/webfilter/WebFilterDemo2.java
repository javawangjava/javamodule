//package com.wang.webfilter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class WebFilterDemo2 implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //放行前，对 servletRequest数据进行处理
//        System.out.println("2.WebFilterDemo2:放行前，对servletRequest数据进行处理");
//        //放行
//        filterChain.doFilter(servletRequest,servletResponse);
//        //放行后，对servletResponse 数据进行处理
//        System.out.println("4.WebFilterDemo2：放行后，对servletResponse反应数据进行处理");
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
//}
