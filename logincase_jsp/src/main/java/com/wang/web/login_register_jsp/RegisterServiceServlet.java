package com.wang.web.login_register_jsp;

import com.wang.pojo.User;
import com.wang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login_register_jsp/registerServiceServlet")
public class RegisterServiceServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1. 获取用户名和密码数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

        // 程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");


        // 比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){

            // 注册失败，重写跳回到注册界面
            request.setAttribute("register_msg","验证码错误");

            // 不清楚请求转发之后，没有css样式，不知道问题所在，所以使用了重定向来实现
            request.getRequestDispatcher("/login_register_jsp/register.jsp").forward(request,response);

            // 不允许注册
            return;
        }


        //2. 调用service 注册
        boolean flag = service.register(user);
        //3. 判断注册成功与否
        if(flag){
            //注册功能，跳转登陆页面
            request.setAttribute("register_msg","注册成功，请登录");

            //不清楚请求转发之后，没有css样式，不知道问题所在，所以使用了重定向来实现
            request.getRequestDispatcher("/login_register_jsp/login.jsp").forward(request,response);

        }else {
            //注册失败，跳转到注册页面
            request.setAttribute("register_msg","用户名已存在");

            // 不清楚请求转发之后，没有css样式，不知道问题所在，所以使用了重定向来实现
            request.getRequestDispatcher("/login_register_jsp/register.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}