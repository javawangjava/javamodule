<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="../css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/logincase_jsp_filter_listener/loginServiceServlet" method="post" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <%--
            修改login.jsp，将错误信息使用EL表达式来获取
            修改前内容:<div id="errorMsg">用户名或密码不正确</div>
            修改后内容: <div id="errorMsg">${login_msg}</div>
        --%>
        <div id="errorMsg">${login_msg} ${register_msg}</div>
        <p>Username:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>
        <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
        <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>


</body>
</html>