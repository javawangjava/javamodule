<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改品牌</title>
</head>
<body>
<h3>修改品牌</h3>
<%--form 标签的 action 属性值改为 /brand-demo/updateServlet--%>
<form action="/brandcase_jsp_jstl_html/jSPBrandUpdateServlet" method="post">
    <%--input 标签要进行数据回显，需要设置 value 属性，在标签体中使用 EL表达式 --%>
    <%--不希望页面将主键id展示给用户看，但是又希望在提交数据时能将主键id提交到后端。隐藏域，提交id--%>
    <input type="hidden" name="id" value="${brand.id}">

    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description} </textarea><br>
    状态：
<%--  单选框使用 if 标签需要判断 brand.status 的值是 1 还是 0 在指定的单选框上使用 checked 属性，表示被选中状态--%>
    <c:if test="${brand.status == 0}">

        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>

    <c:if test="${brand.status == 1}">

        <input type="radio" name="status" value="0" >禁用
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>


    <input type="submit" value="提交">
</form>
</body>
</html>