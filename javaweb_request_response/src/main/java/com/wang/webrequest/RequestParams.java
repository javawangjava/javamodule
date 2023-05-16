package com.wang.webrequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


/*
*
*   【获取请求对象Request的请求参数的通用方式】：使用ServletRequest接口提供的方法。后面一般采用这种方法。
*        1.Map<String,String[]> getParameterMap()：获取Request的所有参数Map集合；
*        2.String[] getParameterValues(String name)：根据Request的参数名称获取参数值（数组）；
*        3.String getParameter(String name)：根据Request的参数名称获取参数值(单个值)；
* 【GET请求中文参数乱码问题】：Tomcat8.0之后，已将GET请求乱码问题解决，设置默认的解码方式为UTF-8。Tomcat8.0之前在pom.xml添加tomcat7插件处配置UTF-8字符集，解决GET请求中文乱码问题。
* 【POST请求中文参数乱码问题】：POST请求解决方案是:设置输入流的编码:request.setCharacterEncoding("UTF-8");注意:设置的字符集要和页面保持一致;
* */


/*
 * Request获取请求参数程序示例：
 *   getRequestParams.html；postRequestParams.html
 *  【GET请求示例1】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/requestParamsTogetherAPI?username=zhangsan&password=123&hobby=1&hobby=2 ；
 *  【GET请求示例2】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/getRequestParams.html
 *  【POST请求示例】：启动tomcat服务器，通过浏览器访问 http://localhost/javaweb_request_response/postRequestParams.html
 * */


@WebServlet("/requestParams")
public class RequestParams extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //【POST请求中文参数乱码问题】：POST请求解决方案是:设置输入流的编码:request.setCharacterEncoding("UTF-8");注意:设置的字符集要和页面保持一致;
        req.setCharacterEncoding("UTF-8");

        // 【方法一：获取request全部参数】Map<String,String[]> getParameterMap()：获取Request的所有参数Map集合；
        // 1.获取请求Request的所有参数的Map集合
        System.out.println("========方法一：获取request全部参数=========");
        Map<String, String[]> paramsMap = req.getParameterMap();
        // 2.遍历所有参数的Map集合
        for (String key : paramsMap.keySet()) {
            System.out.print(key + ":");
            // 3.获取键Key对应的值【数组】，前面paramsMap的值是String[]
            String[] values = paramsMap.get(key);
            // 4.遍历当前键key对应的值的数组
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }


        // 【方法二：根据Request的参数名称获取参数值（数组）】String[] getParameterValues(String name)：根据Request的参数名称获取参数值（数组）；；
        System.out.println("========方法二：根据Request的参数名称获取参数值（数组）========");
        String[] hobbies = req.getParameterValues("hobby");
        for(String hobby:hobbies){
            System.out.println("hobby:"+hobby);
        }


        // 【方法三：根据Request的参数名称获取参数值】String getParameter(String name)：根据Request的参数名称获取参数值(单个值)
        System.out.println("========方法三：根据Request的参数名称获取参数值========");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
