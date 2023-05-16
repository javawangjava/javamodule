package com.wang.web;

public class LoginAndRegisterNoServiceNotes {
/*
*
*
* 用户注册登录案例
*
*
*   用户登录需求分析
*       1. 用户在登录页面输入用户名和密码，提交请求给LoginServlet
*       2. 在LoginServlet中接收请求和数据[用户名和密码]
*       3. 在LoginServlt中通过Mybatis实现调用UserMapper来根据用户名和密码查询数据库表
*       4. 将查询的结果封装到User对象中进行返回
*       5. 在LoginServlet中判断返回的User对象是否为null
*       6. 如果为nul，说明根据用户名和密码没有查询到用户，则登录失败，返回"登录失败"数据给前端
*       7. 如果不为null,则说明用户存在并且密码正确，则登录成功，返回"登录成功"数据给前端
*
*
*   用户注册需求分析
*       1.用户在注册页面输入用户名和密码，提交请求给RegisterServlet；
*       2.在RegisterServlet中接收请求和数据[用户名和密码]；
*       3.在RegisterServlet中通过Mybatis实现调用UserMapper来根据用户名查询数据库表；
*       4.将查询的结果封装到User对象中进行返回；
*       5.在RegisterServlet中判断返回的User对象是否为null；
*       6.如果为nul，说明根据用户名可用，则调用UserMapper来实现添加用户；
*       7.如果不为null,则说明用户不可以，返回"用户名已存在"数据给前端。
*
*
*  jsp本质是Servlet,所以需要启动tomcat服务器之后，在浏览器地址栏输入进行访问。
*
*   登录功能测试：启动tomcat服务器；
*       在浏览器地址栏输入进行访问 http://localhost/logincase_html/login.html
*
*    注册功能测试：启动tomcat服务器；
*       在浏览器地址栏输入进行访问 http://localhost/logincase_html/register.html
*       或者在登录页面点击注册按钮跳转到注册页面
*
*
* */

}
