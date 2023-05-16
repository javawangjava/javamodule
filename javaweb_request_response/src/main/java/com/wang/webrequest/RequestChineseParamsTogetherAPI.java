package com.wang.webrequest;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/*
*
*   【获取请求对象Request的请求参数的通用方式】：使用ServletRequest接口提供的方法。后面一般采用这种方法。
*        1.Map<String,String[]> getParameterMap()：获取Request的所有参数Map集合；
*        2.String[] getParameterValues(String name)：根据Request的参数名称获取参数值（数组）；
*        3.String getParameter(String name)：根据Request的参数名称获取参数值(单个值)；
*
*
*
*    【POST请求中文参数乱码解决方案】：
 *          因为页面设置的编码格式为UTF-8；先设置字符输入流的编码为UTF-8,然后再获取POST请求数据。
 *         【步骤1】：所以在Tomcat8.0版本之前，；先设置编码格式方法：通过request.setCharacterEncoding("UTF-8")设置编码,UTF-8也可以写成小写。
 *         【步骤2】：在设置完字符输入流的编码格式之后再获取请求参数。
*
*    【GET请求中文参数乱码解决方案】：
*         在进行编码和解码的时候，不管使用的是哪个字符集，同一个数据编码后和解码前对应的表示形式是一样的【就是URL编码后的那个数据形式】
*               【URL编码:具体编码过程分两步:(1)将字符串按照编码方式转为二进制;(2)每个字节转为2个16进制数并在前边加上%】
 *        【步骤1】：使用request对象的方法获取URL解码的数据【就是乱码数据】；
 *        【步骤2】：然后按照ISO-8859-1编码规则将乱码数据转换为对应的字节数组；
 *        【步骤3】：最后将前面的字节数组按照UTF-8编码转换为对应的字符串；
*
*
* */


/*
 * Request获取请求参数程序示例：
 *  getRequestChineseParams.html；postRequestChineseParams.html
 *  【GET请求示例1】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/requestChineseParamsTogetherAPI?username=zhangsan&password=123&hobby=1&hobby=2 ；
 *  【GET请求示例2】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/getRequestChineseParams.html
 *  【POST请求示例】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/postRequestChineseParams.html
 *
 * */



@WebServlet("/requestChineseParamsTogetherAPI")
public class RequestChineseParamsTogetherAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username="";
        String password="";
        if("GET".equals(req.getMethod())){
            // 【GET请求中文参数乱码解决方案】Tomcat8.0之后，已将GET请求乱码问题解决，Tomcat8.0之后设置默认的解码方式为UTF-8
            // 【步骤1】：先使用request对象的方法获取URL解码的数据【就是乱码数据】；
            // 【步骤2】：按照ISO-8859-1编码规则将乱码数据转换为对应的字节数组；
            // 【步骤3】：将前面的字节数组按照UTF-8编码转换为对应的字符串；

            System.out.println("========"+req.getMethod()+"请求中文参数乱码解决方案========");
            username = req.getParameter("username");
            password = req.getParameter("password");
            //byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);// 先对乱码数据进行编码：转为字节数组
            //username=new String(bytes, StandardCharsets.UTF_8);// 字节数组解码
            username=new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        }else if("POST".equals(req.getMethod())){
            // 【POST请求中文参数乱码解决方案】在Tomcat8.0版本之前，把Tomcat在获取流数据之前的编码设置为UTF-8
            System.out.println("========"+req.getMethod()+"请求中文参数乱码解决方案========");
            // POST请求中文参数乱码解决方案：在Tomcat8.0版本之前，把Tomcat在获取流数据之前的编码设置为UTF-8,
            // 设置编码格式方法：通过request.setCharacterEncoding("UTF-8")设置编码,UTF-8也可以写成小写。
            req.setCharacterEncoding("UTF-8");
            username = req.getParameter("username");
            password = req.getParameter("password");
        }
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
