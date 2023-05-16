package com.wang.webfilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/*
*
* Filter 表示过滤器
*   过滤器可以把对资源的请求拦截下来，从而实现一些特殊的功能。
*   进行 Filter 开发分成以下三步实现:
*   【步骤一】：定义类，实现 Filter接口，并重写其所有方法,注意这里把super.()那几个方法清掉；
*   【步骤二】：配置Filter拦截资源的路径：在类上定义 @WebFilter 注解。而注解的 value 属性值 /* 表示拦截所有的资源；
*   【步骤三】：在Filter接口的doFilter()方法中添加要放行的内容。其中filterChain.doFilter(servletRequest,servletResponse)表示对请求和反应数据的放行
*
* Filter的执行流程如下：执行放行前逻辑-》放行-》访问资源-》执行放行后逻辑；
* Filter拦截路径配置：拦截路径表示 Filter 会对请求的哪些资源进行拦截，使用 @WebFilter 注解进行配置。
*
在类上定义 @WebFilter 注解配置拦截路径的四种方式：
* 【方式1】：拦截具体的资源：/index.jsp：只有访问index.jsp时才会被拦截；
* 【方式2】：目录拦截：/user/*：访问/user下的所有资源，都会被拦截；
* 【方式3】：后缀名拦截：*.jsp：访问后缀名为jsp的资源，都会被拦截；
* 【方式4】：拦截所有：/*：访问所有资源，都会被拦截；
*
* 过滤器链：过滤器链是指在一个Web应用，可以配置多个过滤器，这多个过滤器称为过滤器链。
* 过滤器链使用注解配置Filter时的优先级是按照过滤器类名(字符串)的自然排序。
*
* */


/*
 * WebFilterDemo和hello.jsp是单独的示例；
 * WebFilterDemo1和WebFilterDemo2是结合在一起看过滤链的执行流程；
 *
 *
 * */


@WebFilter("/*")
public class WebFilterDemo implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.放行前，对servletRequest请求数据进行处理
        System.out.println("1.放行前，对servletRequest请求数据进行处理");
        //2.执行filterChain.doFilter(servletRequest,servletResponse)方法来访问资源
        filterChain.doFilter(servletRequest, servletResponse);
        //3.放行后，对servletResponse反应数据进行处理
        System.out.println("3.放行后，对servletResponse反应数据进行处理");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void destroy() {
    }

}
