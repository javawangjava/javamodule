package com.wang.webcookie;

public class JavaWebCookieNotes {

/**
*
*
* Cookie：客户端会话技术，将数据保存到客户端，以后每次请求都携带Cookie数据进行访问。
*
*
* Cookie的工作流程：
*       1.服务端提供了两个Servlet，分别是ServletA和ServletB;
*       2.浏览器发送HTTP请求1给服务端，服务端ServletA接收请求并进行业务处理;
*       3.服务端ServletA在处理的过程中可以创建一个Cookie对象并将name=zs的数据存入Cookie;
*       4.服务端ServletA在响应数据的时候，会把Cookie对象响应给浏览器;
*       5.浏览器接收到响应数据，会把Cookie对象中的数据存储在浏览器内存中，此时浏览器和服务端就建立了一次会话;
*       6.在同一次会话中浏览器再次发送HTTP请求2给服务端ServletB，浏览器会携带Cookie对象中的所有数据【第二次请求会携带Cookie】;
*       7.ServletB接收到请求和数据后，就可以获取到存储在Cookie对象中的数据，这样同一个会话中的多次请求之间就实现了数据共享;
*
*
* Cookie的基本使用,包含两部分内容:发送Cookie,获取Cookie。
*       发送Cookie：
*           1.创建Cookie对象，并设置数据：Cookie cookie = new Cookie("key","value");
*           2.发送Cookie到客户端使用response对象：response.addCookie(cookie);
*
*       获取Cookie：
*           1.获取客户端携带的所有Cookie，使用request对象：Cookie[] cookies = request.getCookies();;
*           2.遍历数组，获取每一个Cookie对象：for;
*           3.使用Cookie对象方法获取数据:cookie.getName(),cookie.getValue();
*
*
*
* Cookie的原理分析：
*       对于Cookie的实现原理是基于HTTP协议的,其中涉及到HTTP协议中的两个请求头信息:
*           1.响应头:set-cookie；
*           2.请求头: cookie。
*       流程：
*           1.服务器端AServlet和BServlet的作用：AServlet给前端发送Cookie,BServlet从request中获取Cookie的功能；
*           2.对于AServlet响应数据的时候，Tomcat服务器都是基于HTTP协议来响应数据；
*           3.当Tomcat发现后端要返回的是一个Cookie对象之后，Tomcat就会在响应头中添加一行数据SetCookie:name:value【username=zs】；
*           4.浏览器获取到响应结果后，从响应头中就可以获取到Set-Cookie对应值name:value【username=zs】,并将数据存储在浏览器的内存中；
*           5.浏览器再次发送请求给BServlet的时候，浏览器会自动在请求头中添加name:value【username=zs】发送给服务端BServlet；
*           6.Request对象会把请求头中cookie对应的值封装成一个个Cookie对象，最终形成一个数组；
*           7.BServlet通过Request对象获取到Cookie[]后，就可以从中获取自己需要的数据；
*
*
* Cookie的使用细节：
*       注意：浏览器关闭再打开不是指打开一个新的选显卡，而且必须是先关闭再打开，顺序不能变。
*       Cookie的存活时间:
*           1.默认情况下，Cookie存储在浏览器内存中，当浏览器关闭，内存释放，则Cookie被销毁；
*       Cookie持久化存储：
*           1.设置Cookie存活时间：setMaxAge(int seconds)
*               参数值(int seconds)为:
*                   1.正数：将Cookie写入浏览器所在电脑的硬盘，持久化存储。到时间自动删除；
*                   2.负数：默认值，Cookie在当前浏览器内存中，当浏览器关闭，则Cookie被销毁；
*                   3.零：删除对应Cookie【即默认情况，Cookie存储在浏览器内存中，当浏览器关闭，内存释放，则Cookie被销毁】；
*
*
*       Cookie存储中文：
*           1.Cookie不能直接存储中文；
*           2.如果需要存储中文，就需要进行转码：URL编码；
*       Cookie存储中文具体实现思路：
*           1.在发送Cookie前，对中文进行URL编码，将编码后的值存入Cookie中。URL编码采用URLEncoder.encode()。
*           2.那么获取Cookie中的值为URL编码后的值；
*           3.在获取Cookie后，对获取的值在进行URL解码就可以获取到对应的中文值。URL解码采用URLDecoder.decode()。
*
*
*
*
* */







}
