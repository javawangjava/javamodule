package com.wang;

public class JavaWebServletNotes {

/**
*
* Servlet:
*       1.Servlet是JavaWeb最为核心的内容，它是Java提供的一门动态web资源开发技术。
*       2.使用Servlet就可以实现，根据不同的登录用户在页面上动态显示不同内容。
*       3.Servlet是JavaEE规范之一，其实就是一个接口，将来我们需要定义Servlet类实现Servlet接口，并由web服务器运行Servlet。
*       4.Servlet是JavaWeb最为核心的内容，它是Java提供的一门动态web资源开发技术。
*
 *
 * Servlet的执行流程:
 *      1.浏览器发出 http://localhost:8080/web-demo/servletDemo1 请求，从请求中可以解析出三部分内容，分别是 localhost:8080 、 web-demo 、 servletDemo1
 *          1.1:根据 localhost:8080 可以找到要访问的Tomcat Web服务器;
 *          1.2:根据 web-demo 可以找到部署在Tomcat服务器上的web-demo项目;
 *          1.3:根据 servletDemo1  可以找到要访问的是项目中的哪个Servlet类，根据@WebServlet后面的值进行匹配;
 *      2.找到ServletDemo1这个类后，Tomcat Web服务器就会为ServletDemo1这个类创建一个对象，然后调用对象中的service方法;
 *          2.1:ServletDemo1实现了Servlet接口，所以类中必然会重写service方法供Tomcat Web服务器进行调用;
 *          2.2:service方法中有ServletRequest和ServletResponse两个参数，ServletRequest封装的是请求数据，ServletResponse封装的是响应数据，后期我们可以通过这两个参数实现前后端的数据交互;
 *
 *   Servlet由web服务器创建，Servlet方法由web服务器调用。
 *   因为我们自定义的Servlet,必须实现Servlet接口并复写其方法，而Servlet接口中有service方法。
 *
 *
 *
 * Servlet的生命周期：
 *      生命周期: 对象的生命周期指一个对象从被创建到被销毁的整个过程。
 *      Servlet运行在Servlet容器(web服务器)中，其生命周期由容器来管理，分为4个阶段：
 *              1. 加载和实例化：默认情况下，当Servlet第一次被访问时，由容器创建Servlet对象；
 *                  1.1 把Servlet的创建放到服务器启动的时候来创建；
 *                  @WebServlet(urlPatterns = "/servletDemo1",loadOnStartup = 1)
 *                  loadOnstartup的取值有两类情况
 *                      （1）负整数:第一次访问时创建Servlet对象；
 *                      （2）0或正整数:服务器启动时创建Servlet对象，数字越小优先级越高；
 *
 *              2.初始化：在Servlet实例化之后，容器将调用Servlet的init()方法初始化这个对象，完成一些如加载配置文件、创建连接等初始化的工作。该方法只调用一次。
 *              3.请求处理：每次请求Servlet时，Servlet容器都会调用Servlet的service()方法对请求进行处理；
 *              4.服务终止：当需要释放内存或者容器关闭时，容器就会调用Servlet实例的destroy()方法完成资源的释放。在destroy()方法调用之后，容器会释放这个Servlet实例，该实例随后会被Java的垃圾收集器所回收。
 *
 *
 *      Servlet中总共有5个方法：
 *              void init(ServletConfig config)：初始化方法，在Servlet被创建时执行，只执行一次；
 *              void service(ServletRequest req, ServletResponse res)：提供服务方法， 每次Servlet被访问，都会调用该方法；
 *              void destroy()：销毁方法，当Servlet被销毁时，调用该方法。在内存释放或服务器关闭时销毁Servlet法；
 *              String getServletInfo()：获取Servlet信息；该方法用来返回Servlet的相关信息，没有什么太大的用处，一般我们返回一个空字符串即可
 *              ServletConfig getServletConfig()：获取ServletConfig对象；ServletConfig对象，在init方法的参数中有，而Tomcat
 *              Web服务器在创建Servlet对象的时候会调用init方法，必定会传入一个ServletConfig对象，我们只需要将服务器传过来的ServletConfig进行返回即可。
 *
 *
 * Servlet的体系结构
 *      Servlet继承体系：Servlet的继承体系为Servlet-->GenericServlet-->HttpServlet。
 *          1.Servlet:Servlet体系根接口;
 *          2.GenericServlet:Servlet抽象实现类;
 *          3.HttpServlet:对HTTP协议封装的Servlet实现类;
 *          将来开发B/S架构的web项目，都是针对HTTP协议，所以我们自定义Servlet,会通过继承HttpServlet
 *
 *
 * Servlet类的urlPattern配置：使用注解@WebServlet配置访问路径
 *      Servlet类编写好后，要想被访问到，就需要配置其访问路径（urlPattern）。
 *      Servlet从3.0版本后开始支持注解配置，3.0版本前只支持XML配置文件的配置方法。
 *      1. urlPattern总共有四种配置方式，分别是精确匹配、目录匹配、扩展名匹配、任意匹配；
 *      2. 五种配置的优先级为 精确匹配 > 目录匹配> 扩展名匹配 > /* > / ,无需记，以最终运行结果为准。
 *          1.一个Servlet,可以配置多个urlPattern；@WebServlet(urlPatterns ={"/demo7","/demo0"} )
 *          2.urlPattern配置规则： 下面例子中：localhost:8080是服务器地址；web-demo：web项目地址；@WebServlet()：括号中的字符串是类的访问路径。
 *              2.1.精确匹配；配置路径：  @WebServlet("/exactPathServlet")
 *                          访问路径：  http://localhost/javaweb_http_servlet/exactPathServlet
 *
 *              2.2.目录匹配；配置路径：@WebServlet("/servlet/*")
 *                          访问路径：结论是 /user/* 中的 /* 代表的是零或多个层级访问目录同时精确匹配优先级要高于目录匹配。
 *                                  http://localhost/javaweb_http_servlet/servlet/*
 *                                  http://localhost/javaweb_http_servlet/servlet/123
 *                                  http://localhost/javaweb_http_servlet/servlet/456
 *
 *              2.3.扩展名匹配；配置路径：@Webservlet("*.do")
 *                            访问路径：
 * 	                                http://localhost/javaweb_http_servlet/aaa.do
 * 	                                http://localhost/javaweb_http_servlet/bbb.do
 *
 *              2.4.任意匹配:
 *                          配置路径：
 *                                   @Webservlet("/")；@WebServlet("/*")
 *
 *                          配置路径：@Webservlet("/")
 *                          访问路径：http://localhost/javaweb_http_servlet/。当我们的项目中的Servlet配置了 "/",会覆盖掉tomcat中的DefaultServlet,当其他的url-pattern都匹配不上时都会走这个Servlet。
 *
 *                          配置路径：@Webservlet("/*")
 *                          访问路径：http://localhost/javaweb_http_servlet。我们的项目中配置了"/*",意味着匹配项目下的任意类访问路径。
 *
 *                  注意: 任意匹配路径的/ 和 /* 的区别?
 *                      1. 当我们的项目中的Servlet配置了 "/",会覆盖掉tomcat中的DefaultServlet,当其他的url-pattern都匹配不上时都会走这个Servlet。
 *                      2. 当我们的项目中配置了"/*",意味着匹配任意访问路径。
 *                      3. DefaultServlet是用来处理静态资源，如果配置了"/"会把默认的覆盖掉，就会引发请求静态资源的时候没有走默认的而是走了自定义的Servlet类，最终导致静态资源不能被访问。
 *                  具体一点：当任意匹配路径为 @Webservlet("/")，
 *                      3. DefaultServlet是用来处理静态资源，如果配置了"/"会把默认的覆盖掉，就会引发请求静态资源的时候没有走默认的而是走了自定义的Servlet类，最终导致静态资源不能被访问。
 *                      3. DefaultServlet是用来处理静态资源，如果配置了"/"会把默认的覆盖掉，就会引发请求静态资源的时候没有走默认的而是走了自定义的Servlet类，最终导致静态资源不能被访问。
*
*
 * Servlet类的xml配置:
 *      Servlet从3.0版本后开始支持注解配置，3.0版本前只支持XML配置文件的配置方法。
 *
 *
* */

}
