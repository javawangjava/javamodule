package com.wang;

public class WebJavaWebNotes {

/**
*
* Web是全球广域网，也称为万维网(www)，能够通过浏览器访问的网站。
* JavaWeb就是用Java技术来解决相关web互联网领域的技术栈。
* JavaWeb技术栈
*        B/S 架构：Browser/Server，浏览器/服务器 架构模式，它的特点是，客户端只需要浏览器，应用程序的逻辑和数据都存储在服务器端。
*                 浏览器只需要请求服务器，获取Web资源，服务器把Web资源发送给浏览器即可。
*                 B/S架构的好处:易于维护升级：服务器端升级后，客户端无需任何部署就可以使用到新的版本。
*
*   服务器端静态资源：静态资源主要包含HTML、CSS、JavaScript、图片等，主要负责页面的展示。
*   服务器端动态资源：动态资源主要包含Servlet、JSP等，主要用来负责逻辑处理。动态资源处理完逻辑后会把得到的结果交给静态资源来进行展示，动态资源和静态资源要结合一起使用。
*   数据库：数据库主要负责存储数据。
*   服务器端动态资源：动态资源主要包含Servlet、JSP等，主要用来负责逻辑处理。动态资源处理完逻辑后会把得到的结果交给静态资源来进行展示，动态资源和静态资源要结合一起使用。
*
*
*   整个Web的访问过程:
*       (1)浏览器发送一个请求到服务端，去请求所需要的相关资源;
*       (2)资源分为动态资源和静态资源,动态资源可以是使用Java代码按照Servlet和JSP的规范编写的内容;
*       (3)在Java代码可以进行业务处理也可以从数据库中读取数据;
*       (4)拿到数据后，把数据交给HTML页面进行展示,再结合CSS和JavaScript使展示效果更好;
*       (5)服务端将静态资源响应给浏览器;
*       (6)浏览器将这些资源进行解析;
*       (7)解析后将效果展示在浏览器，用户就可以看到最终的结果。
*
*
*
*   HTTP协议:
*       HTTP协议:主要定义通信规则;
*       浏览器发送请求给服务器，服务器响应数据给浏览器，这整个过程都需要遵守一定的规则，这里我们需要使用的是HTTP协议，这也是一种规则.
*
*   Web服务器:
*       Web服务器:负责解析 HTTP 协议，解析请求数据，并发送响应数据;
*       浏览器按照HTTP协议发送请求和数据，后台就需要一个Web服务器软件来根据HTTP协议解析请求和数据，然后把处理结果再按照HTTP协议发送给浏览器;
*       Web服务器软件有很多，我们课程中将学习的是目前最为常用的Tomcat服务器.
*
*       (1)Request(请求)是从客户端向服务端发出的请求对象，
*       (2)Response(响应)是从服务端响应给客户端的结果对象，
*       (3)JSP是动态网页技术,
*       (4)会话技术(Cookie、Session)是用来存储客户端和服务端交互所产生的数据，
*       (5)Filter(过滤器)是用来拦截客户端的请求,
*       (6)Listener(监听器)是用来监听特定事件,
*       (7)Ajax、Vue、ElementUI都是属于前端技术
*
*
*   HTTP:
*       HyperText Transfer Protocol，超文本传输协议，规定了浏览器和服务器之间数据传输的规则。
*       数据传输的规则指的是请求数据和响应数据需要按照指定的格式进行传输。
*
*       HTTP协议特点:
*           1.基于TCP协议: 面向连接，安全。TCP是一种面向连接的(建立连接之前是需要经过三次握手)、可靠的、基于字节流的传输层通信协议，在数据传输方面更安全。
*           2.基于请求-响应模型的:一次请求对应一次响应；请求和响应是一一对应关系。
*           3.HTTP协议是无状态协议:对于事物处理没有记忆能力。每次请求-响应都是独立的；
*               无状态指的是客户端发送HTTP请求给服务端之后，服务端根据请求响应数据，响应完后，不会记录任何信息。缺点:多次请求间不能共享数据。优点:速度快。
*
*
*       HTTP请求数据格式:HTTP请求数据总共分为三部分内容，分别是请求行、请求头、请求体。
*           【请求行】: HTTP请求中的第一行数据，请求行包含三块内容，分别是 GET[请求方式] /[请求URL路径] HTTP/1.1[HTTP协议及版本]。
*               请求方式有七种,最常用的是GET和POST。
*           【请求头】: 第二行开始，格式为key: value形式。
*               请求头中会包含若干个属性，常见的HTTP请求头有:
*                   Host: 表示请求的主机名；
*                   User-Agent: 浏览器版本,例如Chrome浏览器的标识类似Mozilla/5.0 ...Chrome/79，IE浏览器的标识类似Mozilla/5.0 (Windows NT ...)like Gecko；；
*                   Accept：表示浏览器能接收的资源类型，如【text/*】，【image/*】或者【* /*】表示所有；
*                   Accept-Language：表示浏览器偏好的语言，服务器可以据此返回不同语言的网页；
*                   Accept-Encoding：表示浏览器可以支持的压缩类型，例如gzip, deflate等。
*
*           【请求体】: POST请求的最后一部分，存储请求参数
*               GET请求请求参数在请求行中，没有请求体，POST请求请求参数在请求体中；
*               GET请求请求参数大小有限制，POST没有；
*
*       HTTP响应数据格式:响应数据总共分为三部分内容，分别是响应行、响应头、响应体。
*           【响应行】：响应数据的第一行,响应行包含三块内容，分别是 HTTP/1.1[HTTP协议及版本] 200[响应状态码] ok[状态码的描述]
*           【响应头】：第二行开始，格式为key：value形式
*               响应头中会包含若干个属性，常见的HTTP响应头有:
*                   Content-Type：表示该响应内容的类型，例如text/html，image/jpeg；
*                   Content-Length：表示该响应内容的长度（字节数）；
*                   Content-Encoding：表示该响应压缩算法，例如gzip；
*                   Cache-Control：指示客户端应如何缓存，例如max-age=300表示可以最多缓存300秒；
*           【响应体】：最后一部分。存放响应数据
*       HTTP响应状态码:
*           200 ok 客户端请求成功
*           404 Not Found 请求资源不存在
*           500 Internal Server Error 服务端发生不可预期的错误
*
*
*
*  Tomcat：Tomcat是一个轻量级的Web服务器，支持Servlet/JSP少量JavaEE规范，也称为Web容器，Servlet容器。
*       Web服务器：Web服务器是一个应该程序（软件），对HTTP协议的操作进行封装，使得程序员不必直接对协议进行操作，让Web开发更加便捷。主要功能是"提供网上信息浏览服务"。
*       Web服务器是安装在服务器端的一款软件，将来我们把自己写的Web项目部署到Web Tomcat服务器软件中，当Web服务器软件启动后，部署在Web服务器软件中的页面就可以直接通过浏览器来访问了。
*
*       Web服务器软件使用步骤：
*           准备静态资源；
*           下载安装Web服务器软件
*           将静态资源部署到Web服务器上
*           启动Web服务器使用浏览器访问对应的资源
*
*
*       Tomcat安装目录中包含的内容：
*               bin：可执行文件存放目录
*               conf：配置文件存放目录
*               lib：tomcat依赖的jar包
*               logs：日志文件
*               temp：临时文件
*               webapps：应用发布【项目部署】目录
*               work：工作目录
*               bin:目录下有两类文件，一种是以 .bat 结尾的，是Windows系统的可执行文件，一种是以 .sh 结尾的，是Linux系统的可执行文件。
*
*
*       Tomcat动的过程中，控制台有中文乱码，需要修改conf/logging.prooperties。把5个UTF-8转换为GBK。
*       Tomcat关闭：1.直接x掉运行窗口:强制关闭[不建议]。2.bin\shutdown.bat：正常关闭。3.ctrl+c： 正常关闭。
*       Tomcat修改端口：
*           Tomcat默认的端口是8080，要想修改Tomcat启动的端口号，需要修改 conf/server.xml.
*           注: HTTP协议默认端口号为80，如果将Tomcat端口号改为80，则将来访问Tomcat时，将不用输入端口号。
*           Tomcat的端口号取值范围是0-65535之间任意未被占用的端口，如果设置的端口号被占用，启动的时候就会包如下的错误:Address already in use:bind.
*
 *      Tomcat部署项目： 将项目放置到webapps目录下，即部署完成。
 *          一般JavaWeb项目会被打包称war包，然后将war包放到Webapps目录下，Tomcat会自动解压缩war文件
*
*
 *  Web项目结构:<packaging>:打包方式;jar:默认值，war:web项目
 *      Maven Web项目结构: 开发中的项目
 *          hello :项目名称
 *          src:主目录
 *          java:Java代码
 *          resources:资源文件
 *          webapp:Web项目特有目录
 *          html:HTML文件目录可自定义)
 *          WEB-INF:web项目核心目录（必须叫这个名称）
 *          web.xml:Web项目配置文件
 *          test:测试目录
 *
 *      Maven Web项目结构: 开发完成部署的Web项目
 *          hello:项目访问路径（虚拟目录）
 *          html:HTML文件目录（可自定义）
 *          WEB-INF:web项目核心目录（必须叫这个名称）
 *          classes:Java字节码文件
 *          lib:项目所需iar包
 *          web.xml:Web项目配置文件
 *
*       Maven Web项目:
 *          1.开发项目通过执行Maven打包命令package,可以获取到部署的Web项目目录;
 *          2.编译后的Java字节码文件和resources的资源文件，会被放到WEB-INF下的classes目录下;
 *          3.pom.xml中依赖坐标对应的jar包，会被放入WEB-INF下的lib目录下;
*
 *
 *
 *  IDEA使用Tomcat
 *          1.Maven Web项目创建成功后，通过Maven的package命令可以将项目打包成war包，将war文件拷贝到Tomcat的webapps目录下，启动Tomcat就可以将项目部署成功，然后通过浏览器进行访问即可
 *          2.war模式是将WEB工程打成war包，把war包发布到Tomcat服务器上;
 *          3.war exploded模式是将WEB工程以当前文件夹的位置关系发布到Tomcat服务器上;
 *          4.war模式部署成功后，Tomcat的webapps目录下会有部署的项目内容;
 *          5.war exploded模式部署成功后，Tomcat的webapps目录下没有，而使用的是项目的target目录下的内容进行部署;
 *          6.建议大家都选war模式进行部署，更符合项目部署的实际情况;
 *          4.war模式部署成功后，Tomcat的webapps目录下会有部署的项目内容;
 *
 *
 *
 *
*
*/


}
