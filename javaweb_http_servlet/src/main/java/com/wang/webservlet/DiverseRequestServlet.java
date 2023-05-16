package com.wang.webservlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DiverseRequestServlet implements Servlet {

    private ServletConfig servletConfig;// 提升作用域，设置为成员变量

    /**
     * 提供服务
     * 1.调用时机:每次请求Servlet时，Servlet容器都会调用Servlet的service()方法对请求进行处理。
     * 2.调用次数: 多次
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException,
            IOException {
        System.out.println("Servler service...");
        //    获取请求的方式，根据请求方式的不同进行不同的业务处理
        HttpServletRequest request = (HttpServletRequest) servletRequest;// 因为Servlet没有获取请求方式的方法，所以这里要类型转换
        //    1.获取请求方式
        String method = request.getMethod();
        //2.根据请求方式选择对应的处理逻辑
        if ("GET".equals(method)) {
            //    GET请求的处理逻辑
            System.out.println("GET请求...");
        } else if ("POST".equals(method)) {
            //    POST请求的处理逻辑
            System.out.println("POST请求...");
        }
    }



    /**
     * 初始化方法
     * 1. 加载和实例化：默认情况下，当Servlet第一次被访问时，由容器创建Servlet对象；
     * 1.1 把Servlet的创建放到服务器启动的时候来创建；
     *
     * @param servletConfig
     * @throws ServletException
     * @WebServlet(urlPatterns = "/servletLifeCycle",loadOnStartup = 1)
     * loadOnstartup的取值有两类情况:默认为-1，修改为0或者正整数，则会在服务器启动的时候，调用;
     * （1）负整数:第一次访问时创建Servlet对象；
     * （2）0或正整数:服务器启动时创建Servlet对象，数字越小优先级越高；
     * 2.调用次数: 1次;
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("Servlet init...");
    }


    /**
     * 让Servlet中的destroy方法被执行：在Terminal命令行中，先使用 mvn tomcat7:run 启动，然后再使用 ctrl+c 关闭tomcat。
     * 销毁方法。
     * 当需要释放内存或者容器关闭时，容器就会调用Servlet实例的destroy()方法完成资源的释放。在destroy()方法调用之后，容器会释放这个Servlet实例，该实例随后会被Java的垃圾收集器所回收。
     * 1.调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁，调用
     * 2.调用次数: 1次
     */
    @Override
    public void destroy() {
        System.out.println("Servlet destory....");
    }


    /**
     * // ServletConfig getServletConfig()：获取ServletConfig对象；
     * // ServletConfig对象，在init方法的参数中有，而TomcatWeb服务器在创建Servlet对象的时候会调用init方法，必定会传入一个ServletConfig
     * 对象，我们只需要将服务器传过来的ServletConfig进行返回即可。
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }


    /**
     * String getServletInfo()：获取Servlet信息；该方法用来返回Servlet的相关信息，没有什么太大的用处，一般我们返回一个空字符串即可
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "";
    }

}
