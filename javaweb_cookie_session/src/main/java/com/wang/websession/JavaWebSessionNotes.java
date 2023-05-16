package com.wang.websession;

public class JavaWebSessionNotes {

/**
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
* */


}
