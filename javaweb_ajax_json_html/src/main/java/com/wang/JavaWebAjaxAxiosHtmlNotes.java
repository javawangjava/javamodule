package com.wang;

public class JavaWebAjaxAxiosHtmlNotes {


/*
*
*   Java工程师、是做后端开发：通过Java程序从数据库中查询出来数据，然后交给页面进行展示，这样用户就能通过在浏览器通过页面看到数据。
*
*
*   W3C 标准：网页主要由三部分组成。
*       结构：HTML  定义网页的内容；HTML定义页面的整体结构。
*       表现：CSS   描述了网页的布局；CSS是用来美化页面，让页面看起来更加美观。
*       行为：JavaScript   控制了网页的行为；JavaScript可以使网页动起来。
*
*
*
*   HTML 是一门语言，所有的网页都是用HTML 这门语言编写出来的，也就是HTML是用来写网页的。
*   HTML也有专业的解释：HTML(HyperText Markup Language)：超文本标记语言。
*           超文本：超越了文本的限制，比普通文本更强大。除了文字信息，还可以定义图片、音频、视频等内容。
*           标记语言：由标签构成的语言。
*           HTML中的标签都是预定义好的，运行在浏览器上并由浏览器解析，然后展示出对应的效果。
*
*
*       HTML标签规则：
*           HTML 文件以.htm或.html为扩展名。
*           HTML 标签不区分大小写。
*           HTML 标签属性值 单双引皆可。
*           HTML 结构标签：<html>，<head>，<title>，<body>。在IDEA中创建号html文件后，idea会自动加上结构标签。
*
*           <html> 标签是根标签，定义HTML文档。下面有 <head> 标签和 <body> 标签这两个子标签。
*           <head> 标签定义关于文档的信息。
*           <title> 标签定义页面标题名称。<title> 标签是<head> 标签的子标签，它定义的内容会展示在浏览器的标题位置【本页面的最上面位置】。
*           <body> 标签定义文档的主体，该部分的内容会被展示在内容区中【书签栏下面那一部分】。
*           以下标签主要用于html文件的<body>标签内部使用，也就是作用于文档的主体部分。
*
*
*           <h1>~<h6> 标签文本内容的标题标签，文本内容的标题标签中 <h1>最大，<h6>最小。
*           <p> 标签定义新段落。
*           <br> 标签定义换行。
*           <hr> 标签定义水平线。
*           <b> 标签定义粗体文本。
*           <i> 标签定义斜体文本。
*           <u> 标签定义文字下划线。
*
*           图片、音频和视频标签
*           <img src="" width="" height=""> 标签定义图片，
*           <audio src="" controls></audio> 标签定义音频，
*           <video src="" controls width="" height=""></video> 标签定义视频。
*               controls表示音频和视频的播放控件。
*               图片和视频的height属性和width属性有两种设置方式：
*                    方式1：像素：单位是px；
*                    方式2：百分比。占父标签的百分比。例如宽度设置为 50%，意思就是占它的父标签宽度的一般（50%）。
*               图片、音频和视频都有src属性【src规定资源的URL(URL统一资源定位符)】。
*                   src属性【资源路径】有如下两种设置方式：
*                   方式1：绝对路径：绝对路径是网络中的绝对路径。 格式为： 协议://ip地址:端口号/资源名称。
*                   方式2：相对路径：相对位置关系。找当前页面所在目录【文件夹】和其他资源所在目录【文件夹】之间的相对路径。【需要从当前文件所在的目录【文件夹】出发去找目标位置，可以对比两个文件的绝对路径找到第一个不同的父目录【父文件夹】，然后获取相对路径】。
*                        相对路径的表示：
*                               ./ 表示当前目录(这个可以省略)。
*                               ../ 表示上一级路径(目录【文件夹】)。
*                               ../../表示上两级路径(目录【文件夹】)。
*
*
*           <a> 标签定义超链接，用于链接到另一个资源。
*               <a> 标签属性：
*                   href:指定访问资源的URL。hypertext reference。
*                   target:指定打开资源的方式。_self:默认值，在当前页面打开。_blank:在新的空白页面打开。
*
*
*           列表标签
*               有序列表：使用标号对列表的每一项进行标记，默认使用数字进行标记。有序列表中的type属性用来指定标记的标号的类型(数字，字母，罗马数字等)。
*               无序列表：没有使用标号对列表的每一项进行标记，默认使用实心圆点进行标记。无序列表中的type属性用来指定标记的形状。
*               无序列表：没有使用标号对列表的每一项进行标记，默认使用实心圆点进行标记。
*                   <ol> 标签定义有序列表；
*                   <ul> 标签定义无序列表；
*                   <li> 标签定义列表项。list item。
*
*
*
*           表格标签
*               <table> 标签定义表格；
*                       border 属性规定表格边框的宽度；
*                       width 属性规定表格的宽度；
*                       cellspacing 属性规定单元格之间的空白；
*               <tr> 标签定义表格的行；
*                       align 属性规定表格行的内容对齐方式；
*               <th> 标签定义表格的表头行的单元格
*               <td> 标签定义表格的非表头行的单元格；
*                       rowspan 属性规定单元格可横跨的行数；
*                       colspan 属性规定单元格可横跨的列数；
*
*
*
*           布局标签：这两个标签一般都是和CSS结合到一块使用来实现页面的布局。
*               div 标签在浏览器上会有换行的效果，而 span 标签在浏览器上没有换行效果。
*               <div> 标签定义HTML文档中的一个区域部分，经常与CSS一起使用，用来布局网页；
*               <span> 标签用于组合行内元素；
*
*
*
*
*           表单标签：像登陆页面、注册页面等都是表单。
*               表单：在网页中主要负责数据采集功能，使用form标签定义表单。
*               表单项(元素)：不同类型的 input 元素、下拉列表、文本域等。
*               form 是表单标签，它在页面上没有任何展示的效果。需要借助于表单项标签来展示不同的效果。
*                    form 的 action 属性规定当提交表单时向何处发送表单数据，该属性值就是URL。将 form 标签的 action 属性值设置为 # ，表示将其将数据提交到当前页面【不设置action属性也是默认提交到当前页面】。
*                    form 的 method 属性规定用于发送表单数据的方式。
*                       form 的 method 属性取值有如下两种：
*                           method 属性取值为get：method属性的默认值【默认值可以省略】。浏览器会将请求参数会拼接在URL后边；URL的长度有限制 4KB。
*                           method 属性取值为post：浏览器会将数据放到http请求消息体中；请求参数无限制的。
*               表单项：表单项必须要在表单<form>中使用才有效果。
*                           表单项的内容要想被提交，则必须指定其name属性。
*                           每一个标签都有id属性，id属性值是唯一的标识。
*                           单选框radio、复选框checkbox和下拉列表项option需要使用value属性指定提交的值。
*                   <label> 标签定义表单项标注；
*                   <input> 标签定义单行输入框，通过type属性控制输入形式；input 数据框只能输入一行文本。
*                           type属性的取值：
*                                   text：默认值。定义单行的输入字段。
*                                   password：定义密码字段；密码字段字符不会明文显示，而是以星号 * 或圆点 . 替代。
*                                   radio：定义单选按钮
*                                   checkbox：定义复选框
*                                   file：定义文件上传按钮
*                                   hidden：定义隐藏的输入字段
*                                   submit：定义提交按钮，提交按钮会把表单数据发送到服务器
*                                   reset：定义重置按钮，重置按钮会清除表单中的所有数据
*                                   button：定义可点击按钮

*
*                   <select> 标签定义下拉列表，<option> 定义下拉列表的选项。
*                   <textarea> 标签定义文本域，它可以输入多行文本，而 input 数据框只能输入一行文本。
*
*
*
*
*
*
*
*
*   Ajax
*       同步和异步
*           同步发送请求过程:浏览器页面在发送请求给服务器，在服务器处理请求的过程中，浏览器页面不能做其他的操作。只能等到服务器响应结束后，浏览器页面才能继续做其他的操作。
*           异步发送请求过程:浏览器页面发送请求给服务器，在服务器处理请求的过程中，浏览器页面还可以做其他的操作。
*
*       AJAX (Asynchronous JavaScript And XML)：异步的 JavaScript 和 XML。
*       学习了AJAX 后，就可以使用AJAX和服务器进行通信，以达到使用 HTML+AJAX来替换JSP页面
*        AJAX 作用有以下两方面：
*           1. 与服务器进行数据交换：通过AJAX可以给服务器发送请求，服务器将数据直接响应回给浏览器。
*            2. 异步交互：可以在不重新加载整个页面的情况下，与服务器交换数据并更新部分网页的技术，如：搜索联想、用户名是否可用校验，等等…。
*       AJAX原生代码以后用的少。XHR表示异步请求。
*
*
*
*
*   Axios:Axios 对原生的AJAX进行封装，简化书写。
*       Axios基本使用: 发送请求的方式见webapp下的文件：get-axios-servlet.html；post-axios-servlet.html。
*           1.在html文件中引入Axios的js文件：<script src="js/axios-0.18.0.js"></script>；
*           2.使用axios 发送请求，并获取响应结果；
*               【发送get请求】：
*                        <script>
*                            axios({
*                                method:"get",
*                                url:"http://localhost/javaweb_ajax_json/axiosServlet?username=zhangsan",
*                            }).then(function (resp){
*                                alert(resp.data);
*                            })
*                        </script>
*
*
*               【发送post请求】：
*                          <script>
*                                axios({
*                                    method:"post",
*                                    url:"http://localhost/javaweb_ajax_json/axiosServlet",
*                                    data:"username=zhangsan"
*                                }).then(function (resp){
*                                    alert(resp.data);
*                                })
*                          </script>
*
*             axios() 是用来发送异步请求的，小括号中使用 js 对象传递请求相关的参数：
*                   method 属性：用来设置请求方式的。取值为 get 或者 post;
*                   url 属性：用来书写请求的资源路径。如果是 get 请求，需要将请求参数拼接到路径的后面，格式为： url?参数名=参数值&参数名2=参数值2 ;
*                   data 属性：作为请求体被发送的数据。也就是说如果是 post 请求的话，数据需要作为 data 属性的值。
*                   then() 需要传递一个匿名函数【javascript中的匿名函数】。我们将 then() 中传递的匿名函数称为 回调函数，意思是该匿名函数在发送请求时不会被调用，而是在成功响应后调用的函数。
*                   而该回调函数中的 resp 参数是对响应的数据进行封装的对象，通过 resp.data 可以获取到响应的数据。
*
*
*       Axios 已经为所有支持的请求方法提供了别名：简化上面的方法调用书写。
*                get 请求 ： axios.get(url[,config])
*                delete 请求 ： axios.delete(url[,config])
*                head 请求 ： axios.head(url[,config])
*                options 请求 ： axios.option(url[,config])
*                post 请求： axios.post(url[,data[,config])
*                put 请求： axios.put(url[,data[,config])
*                patch 请求： axios.patch(url[,data[,config])
*
*
*
*   JSON：JavaScript Object Notation 。JavaScript 对象表示法.
*           json 格式中的键要求必须使用双引号括起来，这是 json 格式的规定。
*           json 现多用于作为数据载体，在网络中进行数据传输。
*           JavaScript 对象的定义格式：{name:"zhangsan",age:23,city:"北京"}。
*           JSON 对象的定义格式：{"name":"zhangsan","age":23,"city":"北京"}。
*           将查询到的集合数据转换为 json 数据。我们将此过程称为 序列化；如果是将 json 数据转换为 Java 对象，我们称之为反序列化。
*           将 json 数据响应回给浏览器。这里一定要设置响应数据的类型及字符集response.setContentType("text/json;charset=utf-8");
*
*
*       JSON 基础语法
*           JSON 定义格式：JSON 本质就是一个字符串，但是该字符串内容是有一定的格式要求的。
*               var 变量名 = '{"key":value,"key":value,...}';
*           JSON 串的键要求必须使用双引号括起来，而值根据要表示的类型确定。value 的数据类型分为如下
*               数字（整数或浮点数）；字符串（使用双引号括起来）；
*               逻辑值（true或者false）；数组（在方括号中）；
*               对象（在花括号中）；null；
*           对于 js 对象可以通过 js对象.属性名 的方式来获取数据。
*           JS 提供了一个对象 JSON ，该对象有如下两个方法：
*               parse(str) ：将 JSON串转换为 js 对象。使用方式是： var jsObject = JSON.parse(jsonStr);
*               stringify(obj) ：将 js 对象转换为 JSON 串。使用方式是： var jsonStr = JSON.stringify(jsObject);
*
*
*       发送异步请求携带参数:
*               后面我们使用 axios 发送请求时，如果要携带复杂的数据时都会以 JSON 格式进行传递;
*               js 提供的 JSON 对象我们只需要了解一下即可。因为 axios 会自动对 js 对象和 JSON 串进行想换转换;
*               发送异步请求时，如果请求参数是 JSON 格式，那请求方式必须是 POST 。因为 JSON 串需要放在请求体中.
*
*               可以提前定义一个 js 对象，用来封装需要提交的参数，然后使用JSON.stringify(js对象) 转换为 JSON 串，再将该 JSON 串作为 axios 的 data 属性值进行请求参数的提交。
*              我们只需要将需要提交的参数封装成 js 对象，并将该 js 对象作为 axios 的 data 属性值进行，它会自动将 js 对象转换为 JSON 串进行提交
*
*       JSON串和Java对象的相互转换
*               以后我们会以 json 格式的数据进行前后端交互。前端发送请求时，如果是复杂的数据就会以 json 提交给后端；
*               而后端如果需要响应一些复杂的数据时，也需要以 json 格式将数据响应回给浏览器。
*
*       在后端我们就需要重点学习以下两部分操作: 使用API：Fastjson 实现上面两部分操作
*               1.请求数据：JSON字符串转为Java对象;
*               2.响应数据：Java对象转为JSON字符串;
*
*       Fastjson 概述：Fastjson 是阿里巴巴提供的一个Java语言编写的高性能功能完善的 JSON 库，是目前Java语言中最快的 JSON 库，可以实现 Java 对象和 JSON 字符串的相互转换。
*       Fastjson 使用：
*           1.需要在pom文件中添加依赖：Fastjson坐标：fastjson
*           2. Java对象转JSON：String jsonStr = JSON.toJSONString(obj);
*                   将 Java 对象转换为 JSON 串，只需要使用 Fastjson 提供的 JSON 类中的 toJSONString() 静态方法即可。
*           3. JSON字符串转Java对象：User user = JSON.parseObject(jsonStr, User.class);
*                   将 json 转换为 Java 对象，只需要使用 Fastjson 提供的 JSON 类中的 parseObject() 静态方法即可
*
*
*
*
*
*
*
* */

}
