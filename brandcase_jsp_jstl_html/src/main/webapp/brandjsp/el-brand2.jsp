<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>el-brand2</title>
</head>
<body>

<%--
解决EL表达式无法使用的问题：在默认情况下，Servlet 2.3/JSP 1.2是不支持EL表达式的，而Servlet 2.4 /JSP 2.0支持。
第二种设置某个jsp页面使用el表达式：需要在jsp页面加上
<%@ page isELIgnored="false"%>
--%>

${brands}

</body>
</html>
