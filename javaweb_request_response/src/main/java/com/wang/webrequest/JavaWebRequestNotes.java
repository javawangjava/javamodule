package com.wang.webrequest;

public class JavaWebRequestNotes {


/**
*
*
* Request对象
*       Request继承体系：Request的继承体系为ServletRequest-->HttpServletRequest-->RequestFacade。
*           1.ServletRequest:Java提供的请求对象根接口【根接口】；
*           2.HttpServletRequest:Java提供的对Http协议封装的请求对象接口【继承根接口ServletRequest】；
*           3.RequestFacade:Tomcat定义的实现类【实现类RequestFacade实现了HttpServletRequest接口，也间接实现了ServletRequest接口】；
*
*
*       ServletRequest和HttpServletRequest是继承关系，并且两个都是接口，接口是无法创建对象。
*       实现类RequestFacade用来创建对象，那么要使用request对象的方法，就要查接口中的方法。
*           1.实现类RequestFacade实现了HttpServletRequest接口，也间接实现了ServletRequest接口；
*           2.Servlet类中的service方法、doGet方法或者是doPost方法最终都是由Web服务器[Tomcat]来调用的，所以Tomcat提供了方法参数接口的具体实现类，并完成了对象的创建
*           3.使用request对象【使用RequestFacade中方法】，可以直接查看JavaEE的API文档中关于ServletRequest和HttpServletRequest的接口文档。
*           4.Tomcat需要解析请求数据，封装为request对象,并且创建request对象传递到service方法。
*
*
*
* Request获取请求数据：HTTP请求数据总共分为三部分内容，分别是请求行、请求头、请求体。Request对象都提供了对应的API方法来获取对应的值:
*
*       以GET请求为例说明请求行三块内容组成：GET/request-demo/req1?username=zhangsan&password=123 HTTP/1.1
*               GET：GET请求方式；
*               request-demo/req1?username=zhangsan&password=123：请求资源路径；
*               HTTP/1.1：HTTP协议及版本；
*
*       【获取Request请求行数据】：请求行包含三块内容，分别是请求方式、请求资源路径、HTTP协议及版本。
*           使用Request对象来获取请求行的API方法【除了String getQueryString()是GET类型请求独有，其他方法是POST请求和GET请求共有的，】：
*               1.String getMethod()：获取请求方式；
*               2.String getContextPath()：获取虚拟目录(项目访问路径)；
*               3.StringBuffer getRequestURL()：获取URL(统一资源定位符)；
*               4.String getRequestURI()：获取URI(统一资源标识符)；
*               5.String getQueryString()：GET请求获取请求参数【这一个方法仅用于GET请求，因为GET请求的参数在请求行中】
*               【String getQueryString()： Returns the query string that is contained in the request URL after the path】
*               上述方法的使用见RequestLineAPI类。
*
*
*       【获取Request请求头的数据】：格式为键值对形式 key: value如下
*               1.String getHeader(String name)：根据请求头名称获取对应值；
*               上述方法的使用见RequestHeaderAPI类。
*
*
*       【获取Request请求体数据】：注意: 浏览器发送的POST请求才有请求体。
*           浏览器在发送GET请求的时候是没有请求体的；浏览器在发送POST请求的时候是有请求体的；
*           使用Request对象来获取POST请求的请求体的API方法：
*               1.ServletInputStream getInputStream()：获取字节输入流【适合前端发送的是字节数据，字符数据也可以只不过字符数据要指定编码格式】；
*               2.BufferedReader getReader()：获取字符输入流【适合前端发送的是纯文本数据】；
*               上述方法的使用见PostRequestBodyAPI类。
*
*
*
*   请求数据是包含请求行、请求头和请求体的所有数据。
*   请求参数是请求数据中的部分内容。请求参数的位置
*           1.如果是GET请求，请求参数在请求行中【请求行？之后的部分】；
*           2.如果是POST请求，请求参数一般在请求体中；
*       对于请求参数的获取,常用的有以下两种:两种请求获取参数的方式不统一，各自有各自的专用请求获取方式。
*             1.获取GET方式请求参数：String getQueryString()；
*             2.获取POST方式请求参数：BufferedReader getReader()和ServletInputStream getInputStream()；
*
*
*       【获取请求对象Request的请求参数的通用方式】：使用ServletRequest接口提供的方法。后面一般采用这种方法。
*               // 使用通用方式获取请求参数后，屏蔽了GET和POST的请求方式代码的不同。
*               1.Map<String,String[]> getParameterMap()：获取Request的所有参数Map集合；
*               2.String[] getParameterValues(String name)：根据Request的参数名称获取参数值（数组）；
*               3.String getParameter(String name)：根据Request的参数名称获取参数值(单个值)；
*
* URL编码:具体编码过程分两步:(1)将字符串按照编码方式转为二进制;(2)每个字节转为2个16进制数并在前边加上%。
*
*
*
*
*
* Request请求参数中文乱码问题：原理其实要深究HTTP发送请求和Tomcat解析数据的原理和细节，这里大概了解就可以。
*   中文乱码解决方案:
*       1.POST请求和GET请求的参数中如果有中文，后台接收数据就会出现中文乱码问题;
*       2.GET请求在Tomcat8.0以后的版本就不会出现了。Tomcat8.0之前在pom.xml添加tomcat7插件处配置UTF-8字符集，解决GET请求中文乱码问题。
*       3.POST请求解决方案是:设置输入流的编码:request.setCharacterEncoding("UTF-8");注意:设置的字符集要和页面保持一致;
*       4.通用方式（GET/POST）：需要先解码，再编码:new String(username.getBytes("ISO-8859-1"),"UTF-8");。
*
*
*       【POST请求中文参数乱码问题】：
*           【POST请求中文参数乱码原因】：其实就是服务器Tomcat解析流的时候采用的URL解码和浏览器编码流时采用的URL编码格式不一致。
*               1.POST的请求参数是通过request的getReader()来获取流中的数据【是中文参数还是所有参数通过getReader()来获取流中的数据，这个要看源码，先认为是全部用getReader()】；
*               2.在Tomcat8.0版本之前，Tomcat在获取流的时候采用的编码是ISO-8859-1；
*               3.ISO-8859-1编码是不支持中文的，所以会出现乱码；
*
*           【POST请求中文参数乱码解决方案】：将服务器Tomcat解析流的时候采用的URL解码和浏览器编码流时采用的URL编码格式设置一致。在Tomcat服务器获取数据流之前将数据流的编码格式设置为UTF-8。
*                因为页面设置的编码格式为UTF-8；先设置字符输入流的编码为UTF-8,然后再获取POST请求数据。
*               【步骤1】：所以在Tomcat8.0版本之前，；先设置编码格式方法：通过request.setCharacterEncoding("UTF-8")设置编码,UTF-8也可以写成小写。
*               【步骤2】：在设置完字符输入流的编码格式之后再获取请求参数。
*
*
*
*       【POST请求中文参数解决方案不适用于GET请求中文参数乱码问题原因】：
*               1.request.setCharacterEncoding("utf-8")是设置request处理流的编码；
*               2.POST请求获取请求参数的方式是request.getReader()；
*               3.GET请求获取请求参数的方式是request.getQueryString()；
*               4.getQueryString方法并没有通过流的方式获取数据；
*
*
*       【GET请求中文参数乱码问题】：Tomcat8.0之后，已将GET请求乱码问题解决，设置默认的解码方式为UTF-8。Tomcat8.0之前在pom.xml添加tomcat7插件处配置UTF-8字符集，解决GET请求中文乱码问题。
*           GET请求流程：
*               (1)浏览器通过HTTP协议发送请求和数据给后台服务器（Tomcat)；
*               (2)浏览器在发送HTTP的过程中会对中文数据进行URL编码【浏览器把中文参数按照指定的UTF-8进行URL编码】；
*               (3)在进行URL编码的时候会采用页面<meta>标签指定的UTF-8的方式进行编码，张三编码后的结果为%E5%BC%A0%E4%B8%89；
*               (4)后台服务器(Tomcat)接收到%E5%BC%A0%E4%B8%89后会默认按照ISO-8859-1进行URL解码【Tomcat服务器对传输过来的数据流按照ISO-8859-1的URL解码】；
*               (5)由于同一个数据前后编码与解码采用的格式不一样，就会导致后台获取到的数据为乱码。
*
*           【GET请求中文参数乱码原因】：
*               1.浏览器把中文参数按照UTF-8进行URL编码；
*               2.Tomcat对获取到的内容进行了ISO-8859-1的URL解码；
*               3.GET请求获取请求参数的方式是request.getQueryString()【GET请求获取请求参数获取的是请求参数的某一种编码的字符串形式】；
*               4.在控制台就会出现类上å¼ ä¸的乱码，最后一位是个空格；
*
*
*           【GET请求中文参数乱码解决方案】：
*               在进行编码和解码的时候，不管使用的是哪个字符集，同一个数据编码后和解码前对应的表示形式是一样的【就是URL编码后的那个数据形式】
*               【URL编码:具体编码过程分两步:(1)将字符串按照编码方式转为二进制;(2)每个字节转为2个16进制数并在前边加上%】
*
*              【步骤1】：使用request对象的方法获取URL解码的数据【就是乱码数据】；
*              【步骤2】：然后按照ISO-8859-1编码规则将乱码数据转换为对应的字节数组；
*              【步骤3】：最后将前面的字节数组按照UTF-8编码转换为对应的字符串；
*
*
*
* Request请求转发:请求转发(forward):一种在服务器内部的资源跳转方式。
*           (1)浏览器发送请求给服务器，服务器中对应的资源A接收到请求;
*           (2)资源A处理完请求后将请求发给资源B;
*           (3)资源B处理完后将结果响应给浏览器;
*           (4)请求从资源A到资源B的过程就叫请求转发。
*
*       Request对象请求转发的实现方式:req.getRequestDispatcher("资源B路径").forward(req,resp);
*       请求转发资源间共享数据:使用Request对象
*           void setAttribute(String name,Object o)：存储数据到request域[范围,数据是存储在request对象]中；
*           Object getAttribute(String name)：根据key获取值；
*           void removeAttribute(String name)：根据key删除该键值对；
*
*       Request请求转发的特点:
*           1.浏览器地址栏路径不发生变化;虽然后台从/req5转发到/req6,但是浏览器的地址一直是/req5,未发生变化;
*           2.只能转发到当前服务器的内部资源,不能从一个服务器通过转发访问另一台服务器;
*           3.一次请求，可以在转发资源间使用request共享数据,虽然后台从/req5转发到/req6，但是这个只有一次请求。
*
*
*
* */


}
