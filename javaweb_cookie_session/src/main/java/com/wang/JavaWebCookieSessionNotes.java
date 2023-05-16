package com.wang;

public class JavaWebCookieSessionNotes {

/**
*
 *
 * 会话:用户打开浏览器，访问web服务器的资源，会话建立，直到有一方断开连接，会话结束。在一次会话中可以包含多次请求和响应。
 *       1.从浏览器发出请求到服务端响应数据给前端之后，一次会话(在浏览器和服务器之间)就被建立了;
 *       2.会话被建立后，如果浏览器或服务端都没有被关闭，则会话就会持续建立着;
 *       3.浏览器和服务器就可以继续使用该会话进行请求发送和响应，上述的整个过程就被称之为会话;
 *
 *
 * 会话跟踪:一种维护浏览器状态的方法，服务器需要识别多次请求是否来自于同一浏览器，以便在同一次会话的多次请求间共享数据。
 *       1.服务器会收到多个请求，这多个请求可能来自多个浏览器;
 *       2.服务器需要用来识别请求是否来自同一个浏览器;
 *       3.服务器用来识别浏览器的过程，这个过程就是会话跟踪;
 *       4.服务器识别浏览器后就可以在同一个会话中多次请求之间来共享数据;
 *
 *
 * 为什么现在浏览器和服务器不支持数据共享?
 *       1.浏览器和服务器之间使用的是HTTP请求来进行数据传输;
 *       2.HTTP协议是无状态的，每次浏览器向服务器请求时，服务器都会将该请求视为新的请求;
 *       3.HTTP协议设计成无状态的目的是让每次请求之间相互独立，互不影响;
 *       4.请求与请求之间独立后，就无法实现多次请求之间的数据共享;
 *
 *
 * 如何实现会话跟踪技术?
 *       1.客户端会话跟踪技术：Cookie;
 *       2.服务端会话跟踪技术：Session;
 *       这两个技术都可以实现会话跟踪，它们之间最大的区别:Cookie是存储在浏览器端而Session是存储在服务器端。
 *
*
* Cookie和Session小结:
*       Cookie 和 Session 都是来完成一次会话内多次请求间数据共享的。
*       区别:
*           1.存储位置：Cookie 是将数据存储在客户端，Session 将数据存储在服务端;
*           2.安全性：Cookie不安全，Session安全;
*           3.数据大小：Cookie最大3KB，Session无大小限制;
*           4.存储时间：Cookie可以通过setMaxAge()长期存储，Session默认30分钟;
*           5.服务器性能：Cookie不占服务器资源，Session占用服务器资源;
*           4.存储时间：Cookie可以通过setMaxAge()长期存储，Session默认30分钟;
*           4.存储时间：Cookie可以通过setMaxAge()长期存储，Session默认30分钟;
*
*       应用场景:
*           1.购物车:使用Cookie来存储;
*           2.以登录用户的名称展示:使用Session来存储;
*           3.记住我功能:使用Cookie来存储;
*           4.验证码:使用session来存储;
*
*       结论:
*           1.Cookie是用来保证用户在未登录情况下的身份识别;
*           2.Session是用来保存用户登录后的数据;
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
 *
 * Session：服务端会话跟踪技术：将数据保存到服务端。
 *       1.Session是存储在服务端而Cookie是存储在客户端;
 *       2.存储在客户端的数据容易被窃取和截获，存在很多不安全的因素;
 *       3.存储在服务端的数据相比于客户端来说就更安全;
 *
 *
 * Session的工作流程:
 *       1.在服务端的AServlet获取一个Session对象，把数据存入其中;
 *       2.在服务端的BServlet获取到相同的Session对象，从中取出数据;
 *       3.就可以实现一次会话中多次请求之间的数据共享了;
 *       1.Session是存储在服务端而Cookie是存储在客户端;
 *
 *
 * Session的基本使用:在JavaEE中提供了HttpSession接口，来实现一次会话的多次请求之间数据共享功能。
 *       1.获取Session对象,使用的是request对象:HttpSession session = request.getSession();
 *       2.Session对象提供的功能:
 *           注意:Session中可以存储的是一个Object类型的数据，也就是说Session中可以存储任意数据类型。
 *           存储数据到 session 域中:void setAttribute(String name, Object o);
 *           根据 key，获取值:Object getAttribute(String name);
 *           根据 key，删除该键值对:void removeAttribute(String name);
 *
 *
 *
 * Session的原理分析：
 *       Session是基于Cookie实现的。
 *           Session的具体实现原理:(1)前提条件：Session要想实现一次会话多次请求之间的数据共享，就必须要保证多次请求获取Session的对象是同一个。
 *           Session实现的也是一次会话中的多次请求之间的数据共享。
 *           注意:在一台电脑上演示的时候，如果是相同的浏览器必须要把浏览器全部关掉重新打开，才算新开的一个浏览器。
 *
 *       Session流程：
 *           1.demo1在第一次获取session对象的时候，session对象会有一个唯一的标识，假如是id:10；
 *           2.demo1在session中存入其他数据并处理完成所有业务后，需要通过Tomcat服务器响应结果给浏览器；
 *           3.Tomcat服务器发现业务处理中使用了session对象，就会把session的唯一标识id:10当做一个cookie，添加Set-Cookie:JESSIONID=10到响应头中，并响应给浏览器；
 *           4.浏览器接收到响应结果后，会把响应头中的coookie数据存储到浏览器的内存中；
 *           5.浏览器在同一会话中访问demo2的时候，会把cookie中的数据按照cookie: JESSIONID=10的格式添加到请求头中并发送给服务器Tomcat；
 *           6.demo2获取到请求后，从请求头中就读取cookie中的JSESSIONID值为10，然后就会到服务器内存中寻找id:10的session对象，如果找到了，就直接返回该对象，如果没有则新创建一个session对象；
 *           7.关闭打开浏览器后，因为浏览器的cookie已被销毁，所以就没有JESSIONID的数据，服务端获取到的session就是一个全新的session对象；
 *
 *
 * 那如何才是正常关闭Tomcat服务器呢?
 *       需要使用命令行的方式来启动和停止Tomcat服务器:
 *           1.启动:进入到对应项目pom.xml所在目录，执行tomcat7:run；
 *           2.停止:在启动的命令行界面，输入ctrl+c.
 *
 *
 *
 * Session的使用细节：
 *       客户端在同一个会话中，只要服务器是正常关闭和启动，session中的数据是可以被保存下来的：
 *       1.session数据存储在服务端，服务器重启后，session数据会被保存；
 *       2.浏览器被关闭启动后，重新建立的连接就已经是一个全新的会话，获取的session数据也是一个新的对象；
 *       3.session的数据要想共享，浏览器不能关闭，所以session数据不能长期保存数据；
 *       4.cookie是存储在客户端，是可以长期保存；
 *
 *       Session钝化与活化：
 *           1.钝化：在服务器正常关闭后，Tomcat会自动将Session数据写入硬盘的文件中：钝化的数据路径为:项目目录\target\tomcat\work\Tomcat\localhost\项目名称\SESSIONS.ser
 *           2.活化：再次启动服务器后，从文件中加载数据到Session中：数据加载到Session中后，路径中的SESSIONS.ser文件会被删除掉.
 *
 *
 * Session销毁：
 *       session的销毁会有两种方式:
 *           1.自动销毁：默认情况下，无操作，30分钟自动销毁；
 *               对于这个失效时间，是可以手动通过配置进行修改的：在项目的web.xml中配置。
 *               如果没有手动额外配置，默认是30分钟，默认值是在Tomcat的web.xml配置文件中写死的
 *           2.手动销毁：手动调用Session对象的invalidate()进行销毁,该销毁方法一般会在用户退出的时候，需要将session销毁掉。
 *
 *
*
* */

}
