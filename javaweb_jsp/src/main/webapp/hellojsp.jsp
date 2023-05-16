<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>

<body>
<h1>hello jsp</h1>

<%-- <%...%>：内容会直接放到_jspService()方法之中；--%>
<%
    out.println("hellojsp.jsp");
    int age = 20;
%>

<%-- <%=…%>：内容会放到out.print()中，作为out.print()的参数；--%>
<%="money"%>
<%="age"%>

<%--    <%!…%>：内容会放到_jspService()方法之外，被类直接包含,就是成员位置--%>
<%!
    void show() {
    }

    String name = "zhangsan";
%>

</body>

</html>
