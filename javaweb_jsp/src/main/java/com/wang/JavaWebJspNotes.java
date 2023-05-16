package com.wang;

public class JavaWebJspNotes {

/*
*
* JSP（全称：Java Server Pages）：Java 服务端页面。是一种动态的网页技术，其中既可以定义 HTML、JS、CSS等静态内容，还可以定义 Java代码的动态内容，
*       也就是 JSP = HTML + Java。
*       JSP 作用：简化开发，避免了在Servlet中直接输出HTML标签。
*       JSP 依赖：jsp-api。<scope>provided</scope>该依赖的 scope 必须设置为 provided ，因为 tomcat 中有这个jar包了，所以在打包时我们是不希望将该依赖打进到我们工程的war包中
*
*       JSP使用步骤：
*           【步骤一】创建一个maven的 web 项目，在pom中导入依赖和插件：javax.servlet-api；jsp-api【<scope>provided</scope>】；tomcat7-maven-plugin。
*           【步骤二】创建 jsp 页面，并在该jsp页面中书写HTML标签和Java代码。
*           【步骤三】启动服务器，在浏览器地址栏输入jsp文件的url进行访问【JSP 本质上就是一个 Servlet，所以要启动tomcat服务器】。
*
*
*       JSP 原理：JSP 本质上就是一个 Servlet【从源码的继承关系上面看出来的】。
*
*       访问 JSP 的流程：
*           1.浏览器第一次访问 hellojsp.jsp 页面；
*           2.tomcat 会将 hellojsp.jsp 转换为名为 hello_jsp.java 的一个 Servlet：
*           3.tomcat 再将转换的 servlet 编译成字节码文件 hello_jsp.class；
*           4.tomcat 会执行该字节码文件，向外提供服务；
*           可以到项目所在磁盘目录下找 target\tomcat\work\Tomcat\localhost\jsp-demo\org\apache\jsp 目录，而这个目录下就能看到转换后的 servlet；
*
*
*       JSP 脚本：JSP脚本用于在 JSP页面内定义 Java代码。
*           JSP 脚本分类：JSP 脚本有如下三个分类：
*               1.<%...%>：内容会直接放到_jspService()方法之中；
*               2.<%=…%>：内容会放到out.print()中，作为out.print()的参数；
*               3.<%!…%>：内容会放到_jspService()方法之外，被类直接包含；
*
*       JSP缺点：
*           书写麻烦：既要写 HTML 标签，还要写 Java 代码；
*           阅读麻烦：既要写 HTML 标签，还要写 Java 代码；
*           复杂度高：运行需要依赖于各种环境，JRE，JSP容器，JavaEE…；
*           占内存和磁盘：JSP会自动生成.java和.class文件占磁盘，运行的是.class文件占内存；
*           调试困难：出错后，需要找到自动生成的.java文件进行调试；
*           不利于团队协作：前端人员不会 Java，后端人员不精 HTML；
*
*
*
*       JSP 已逐渐退出历史舞台，以后开发更多的是使用 HTML + Ajax 来替代。
*       Ajax 是我们后续会重点学习的技术。有个这个技术后，前端工程师负责前端页面开发，而后端工程师只负责前端代码开发。
*
*       技术的发展说明：
*           Servlet->JSP->Servlet+JSP->Servlet+html+ajax
*
*           1. 第一阶段：使用 servlet 即实现逻辑代码编写，也对页面进行拼接。
*           2. 第二阶段：随着技术的发展，出现了 JSP ，人们发现 JSP 使用起来比 Servlet 方便很多，但是还是要在 JSP 中嵌套 Java 代码，也不利于后期的维护。
*           3. 第三阶段：使用 Servlet 进行逻辑代码开发，而使用 JSP 进行数据展示。
*           4. 第四阶段：使用 servlet 进行后端逻辑代码开发，而使用 HTML 进行静态数据展示，使用 ajax 进行动态数据展示。
*
*
*   使用 EL表达式 和 JSTL 标签库替换 JSP 中的 Java 代码。
*   EL 表达式： https://blog.csdn.net/qq_48033003/article/details/117508888
*   EL 表达式：EL（全称Expression Language ）表达式语言，用于简化 JSP 页面内的 Java 代码。
*       EL 表达式的主要作用是 获取数据。其实就是从域对象中获取数据，然后将数据展示在页面上。
*       而 EL 表达式的语法也比较简单，${expression} 。例如：${brands} 就是获取域中存储的 key 为 brands 的数据。
*
*
*       EL表达式兼容性设置
*           解决EL表达式无法使用的问题：在默认情况下，Servlet 2.3/JSP 1.2是不支持EL表达式的，而Servlet 2.4 /JSP 2.0支持。
*           第一种修改web.xml文件：
*               <web-app version="2.4"
*               xmlns="http://java.sun.com/xml/ns/javaee"
*               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
*               xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
*               http://java.sun.com/xml/ns/javaee/web-app_2_4.xsd">
*
*           第二种设置某个jsp页面使用el表达式：需要在jsp页面加上<%@ page isELIgnored="false"%>
*           第三种web.xml文件中加上下列代码，每个jsp页面都可以使用：
*               <jsp-config>
*                 <jsp-property-group>
*                   <url-pattern>*.jsp</url-pattern>
*                   <el-ignored>false</el-ignored>
*                 </jsp-property-group>
*               </jsp-config>
*
*
*       EL表达式中的".“和”[]"的用法：
*               EL表达式提供".“和”[]"两种运算符来存取数据。
*               以下两种情况必须使用"[]"：
*                   1.包含特殊符号：${user.first-name}错误写法；${user[“first-name”]}正确写法。
*                   2.通过变量动态取值：${user[param]}。
*
*       EL表达式的变量：EL存取变量数据的方法很简单，例如：${username}它的意思是取出某一个范围中名称为username的变量。
*
*
*     域对象：
*           JavaWeb中有四大域对象，分别是：从小到大：page->request->session->application
*               page：当前页面有效；
*               request：当前请求有效；
*               session：当前会话有效；
*               application：当前应用有效；
*           el 表达式获取数据，会依次从这4个域中寻找，直到找到为止。
*           例如： ${brands}，el 表达式获取数据，会先从page域对象中获取数据，如果没有再到 requet 域对象中获取数据，如果再没有再到 session 域对象中获取，如果还没有才会到 application 中获取数据。。
*
*
* */

}
