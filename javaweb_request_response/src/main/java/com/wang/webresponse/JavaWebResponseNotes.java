package com.wang.webresponse;

public class JavaWebResponseNotes {


/**
*
* Request:使用request对象来获取请求数据;
* Response:使用response对象来设置响应数据。
*
 *
 *  Response对象：
 *      Response继承体系：Response的继承体系为ServletResponse-->HttpServletResponse-->ResponseFacade。
 *          1.ServletResponse:Java提供的请求对象根接口【根接口】；
 *          2.HttpServletResponse:Java提供的对Http协议封装的请求对象接口【继承根接口ServletResponse】；
 *          3.ResponseFacade:Tomcat定义的实现类【实现类ResponseFacade实现了HttpServletResponse接口，也间接实现了ServletResponse接口】；
 *
 *
 *  Response对象设置相应数据：
 *      HTTP响应数据总共分为三部分内容，分别是响应行、响应头、响应体。
 *          【响应行】：HTTP/1.1 200 OK
 *                 HTTP协议及版本：HTTP/1.1；
 *                 响应状态码：200；
 *                 状态码的描述：OK；
 *                 对于相应行，Response对象设置响应行响应状态码：void setStatus(int sc);
 *
 *          【响应头】：Content-Type:text/html
 *                 键：Content-Type；
 *                 值：text/html；
 *                 Response对象设置响应头键值对：void setHeader(String name,String value);
 *
 *          【响应体】：<html><head>head><body></body></html>
 *                 对于响应体是通过字符、字节输出流的方式往浏览器写。
 *                 PrintWriter getWriter()：获取字符输出流；
 *                 ServletOutputStream getOutputStream()：获取字节输出流；
 *
 *          void setContentType(String type):设置Response对象返回到客户端的内容形式。
 *
*
*
*   Respones请求重定向：Response重定向(redirect):一种资源跳转方式。
*               (1)浏览器发送请求给服务器，服务器中对应的资源A接收到请求；
*               (2)资源A现在无法处理该请求，就会给浏览器响应一个302的状态码+location的一个访问资源B的路径；
*               (3)浏览器接收到响应状态码为302就会重新发送请求到location对应的访问地址去访问资源B；
*               (4)资源B接收到请求后进行处理并最终给浏览器响应结果，这整个过程就叫重定向。
*
*           void sendRedirect(String location):Response对象的重定向方法。
*           重定向的实现方式：
*              实现重定向方式1：
*                   resp.setStatus(302);// 设置状态码302
*                   resp.setHeader("location","资源B的访问路径");//设置响应头
*               实现重定向方式2：
*                   resp.sendRedirect("资源B的访问路径");// 重定向
*               实现重定向方式3：动态获取虚拟目录
*                   String contextPath=req.getContextPath();
*                   resp.sendRedirect(contextPath+"资源B的访问路径");// 重定向
*
*
*
*           Respones重定向的特点:
*               1.浏览器地址栏路径发送变化;当进行重定向访问的时候，由于是由浏览器发送的两次请求，所以地址会发生变化;
*               2.可以重定向到任何位置的资源(服务内容、外部均可);因为第一次响应结果中包含了浏览器下次要跳转的路径，所以这个路径是可以任意位置资源
*               3.两次请求，不能在多个资源使用request共享数据;因为浏览器发送了两次请求，是两个不同的request对象，就无法通过request对象进行共享数据.
*
*
*   请求重定向和请求转发:
*           重定向特点：
*               1.浏览器地址栏路径发生变化;
*               2.可以重定向到任意位置的资源(服务器内部、外部均可);
*               3.两次请求，不能在多个资源使用request共享数据;
*
*           请求转发特点：
*               1.浏览器地址栏路径不发生变化;
*               2.只能转发到当前服务器的内部资源;
*               3.一次请求，可以在转发的资源间使用request共享数据.
*
*
*   请求重定向和请求转发的请求路径问题：
*           转发和重定向时是否要加虚拟目录【项目访问目录】规则：
*               1.浏览器使用:需要加虚拟目录(项目访问路径)；对于重定向来说，路径最终是由浏览器来发送请求，就需要添加虚拟目录。
*               2.服务端使用:不需要加虚拟目录；对于转发来说，因为是在服务端进行的，所以不需要加虚拟目录。
*
*
*
*   Response响应字符数据：
*       一次请求响应结束后，response对象就会被销毁掉，所以不要手动关闭字符输出流。
*       void setContentType(String type):设置Response对象返回到客户端的内容形式。
*       将字符数据写回到浏览器，我们需要两个步骤：
*       【步骤一】：设置响应的数据格式及数据的编码: //void setContentType(String type):设置Response对象返回到客户端的内容形式。
*               response.setContentType("text/html;charset=UTF-8");
*       【步骤二】：通过Response对象获取字符输出流： PrintWriter writer = resp.getWriter();
*       【步骤三】：通过字符输出流写数据: writer.write("aaa");
*
*
*
*   Response响应字节数据：
*       一次请求响应结束后，response对象就会被销毁掉，所以不要手动关闭字符输出流。
*       void setContentType(String type):设置Response对象返回到客户端的内容形式。
*       将字节数据写回到浏览器，我们需要两个步骤：
*       【步骤一】：字符输入流读取文件；FileInputStream fis = new FileInputStream("d://小学英语语法思维导图（1图）.pdf");
*       【步骤二】：通过Response对象获取字节输出流：ServletOutputStream outputStream =resp.getOutputStream();
*       【步骤三】：通过字节输出流写数据: outputStream.write(字节数据)。这里拷贝的过程可以调用工具类【IOUtils.copy(fis,os);fis:输入流；os:输出流】或者字节写拷贝方式。
*       【步骤四】：完成字符输出，需要再方法结束的时候关闭字节输入流【字节输入流是自己开启的】;
*
*
*
* */

}
