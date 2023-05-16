<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%--
在该页面表格的上面添加 新增 按钮；<input type="button" value="新增" id="add"><br>
并给该按钮绑定单击事件，当点击了该按钮需要跳转到 brand.jsp 添加品牌数据的页面
--%>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>


    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/brandcase_jsp_jstl_html/jSPBrandSelectByIdServlet?id=${brand.id}">修改</a> <a href="#">删除</a></td>
        </tr>

    </c:forEach>

</table>

<%--
在该页面表格的上面添加 新增 按钮；<input type="button" value="新增" id="add"><br>
并给该按钮绑定单击事件，当点击了该按钮需要跳转到 brand.jsp 添加品牌数据的页面
--%>

<script>
    document.getElementById("add").onclick = function (){
        location.href = "/brandcase_jsp_jstl_html/brandcasejsp/brandcaseAddBrand.jsp";
    }
</script>
</body>
</html>