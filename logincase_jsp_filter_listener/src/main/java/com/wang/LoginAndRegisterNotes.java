package com.wang;

public class LoginAndRegisterNotes {

/*
*
*
*  jsp本质是Servlet,所以需要启动tomcat服务器之后，在浏览器地址栏输入进行访问。
*   测试：启动tomcat服务器，并在浏览器输入
* 用户登录测试
*
*
* 用户注册登录案例
 *   有Service层：
 *   resources的webapp下login_register_jsp文件夹中的login.html和login.jsp只是名字不一样。
 *   没有webapp下的login_register_html文件夹中内容
 *
* 用户登录注册
*   需求分析:
*       1. 完成用户登录功能，如果用户勾选“记住用户” ，则下次访问登录页面自动填充用户名密码;
*       2. 完成注册功能，并实现验证码功能;
*
*   用户登录功能
*       需求:
*           用户登录成功后，跳转到列表页面，并在页面上展示当前登录的用户名称;
*           用户登录失败后，跳转回登录页面，并在页面上展示对应的错误信息;
*
*       用户登录功能实现流程分析
*           (1)前端通过表单发送请求和数据给Web层的LoginServlet
*           (2)在LoginServlet中接收请求和数据[用户名和密码]
*           (3)LoginServlet接收到请求和数据后，调用Service层完成根据用户名和密码查询用户对象
*           (4)在Service层需要编写UserService类，在类中实现login方法，方法中调用Dao层的UserMapper
*           (5)在UserMapper接口中，声明一个根据用户名和密码查询用户信息的方法
*           (6)Dao层把数据查询出来以后，将返回数据封装到User对象，将对象交给Service层
*           (7)Service层将数据返回给Web层
*           (8)Web层获取到User对象后，判断User对象，如果为Null,则将错误信息响应给登录页面，如果不为Null，则跳转到列表页面，并把当前登录用户的信息存入Session携带到列表页面。
*
*      在LoginServlet中，将登录成功的用户数据存入session中，方法在列表页面中获取当前登录用户信息进行展示。
*      在LoginServlet中，将登录失败的错误信息存入到request中，如果存入到session中就会出现这次会话的所有请求都有登录失败的错误信息，这个是不需要的，所以不用存入到session中。
*
*   记住我-设置Cookie
*       如果用户勾选“记住用户” ，则下次访问登陆页面自动填充用户名密码。这样可以提升用户的体验。
*       实现流程分析
*           将用户名和密码写入Cookie中，并且持久化存储Cookie,下次访问浏览器会自动携带Cookie
*           在页面获取Cookie数据后，设置到用户名和密码框中
*           何时写入Cookie?
*               用户必须登陆成功后才需要写
*               用户必须在登录页面勾选了记住我的复选框
*
*      (1)前端需要在发送请求和数据的时候，多携带一个用户是否勾选Remember的数据；
*      (2)LoginServlet获取到数据后，调用Service完成用户名和密码的判定；
*      (3)登录成功，并且用户在前端勾选了记住我，需要往Cookie中写入用户名和密码的数据，并设置Cookie存活时间；
*      (4)设置成功后，将数据响应给前端。
*
*
*   记住我-获取Cookie
*       登录成功并勾选了Remeber后，后端返回给前端的Cookie数据就已经存储好了，接下来就需要在页面获取Cookie中的数据，并把数据设置到登录页面的用户名和密码框中。
*       实现流程分析
*           在页面可以使用EL表达式，${cookie.key.value}，key:指的是存储在cookie中的键名称
*           (1)在login.jsp用户名的表单输入框使用value值给表单元素添加默认值，value可以使用${cookie.username.value}；
*           (2)在login.jsp密码的表单输入框使用value值给表单元素添加默认值，value可以使用${cookie.password.value}；
*
*
*
*   用户注册功能
*       需求:
*           注册功能：保存用户信息到数据库;
*           验证码功能:
*               展示验证码：展示验证码图片，并可以点击切换;
*               校验验证码：验证码填写不正确，则注册失败;
*           实现流程分析:
*               (1)前端通过表单发送请求和数据给Web层的RegisterServlet;
*               (2)在RegisterServlet中接收请求和数据[用户名和密码];
*               (3)RegisterServlet接收到请求和数据后，调用Service层完成用户信息的保存;
*               (4)在Service层需要编写UserService类，在类中实现register方法，需要判断用户是否已经存在，如果不存在，则完成用户数据的保存;
*               (5)在UserMapper接口中，声明两个方法，一个是根据用户名查询用户信息方法，另一个是保存用户信息方法;
*               (6)在UserService类中保存成功则返回true，失败则返回false,将数据返回给Web层;
*               (7)Web层获取到结果后，如果返回的是true,则提示注册成功，并转发到登录页面，如果返回false则提示用户名已存在并转发到注册页面;
*
*
*   验证码-展示
*       需求分析
*           展示验证码：展示验证码图片，并可以点击切换。
*           验证码的生成是通过工具类来实现的
*
*       生成完验证码以后，我们就可以知晓:
*           验证码就是使用Java代码生成的一张图片；
*           验证码的作用:防止机器自动注册，攻击服务器；
*
*       验证码实现流程分析：
*           (1)前端发送请求给CheckCodeServle；
*           (2)CheckCodeServlet接收到请求后，生成验证码图片，将图片用Reponse对象的输出流写回到前端；
*       思考:如何将图片写回到前端浏览器呢?
*           (1)Java中已经有工具类生成验证码图片，测试类中只是把图片生成到磁盘上 ；
*           (2)生成磁盘的过程中使用的是OutputStream流，如何把这个图片生成在页面呢?
*           (3)前面在将Reponse对象的时候，它有一个方法可以获取其字节输出流，getOutputStream() ；
*           (4)综上所述，我们可以把写往磁盘的流对象更好成Response的字节流，即可完成图片响应给前端。
*
*   验证码-校验
*       需求
*           判断程序生成的验证码 和 用户输入的验证码 是否一样，如果不一样，则阻止注册
*           验证码图片访问和提交注册表单是两次请求，所以要将程序生成的验证码存入Session中
*       思考:为什么要把验证码数据存入到Session中呢?
*           生成验证码和校验验证码是两次请求，此处就需要在一个会话的两次请求之间共享数据。
*           验证码属于安全数据类的，所以我们选中Session来存储验证码数据。
*
*       实现流程分析
*           (1)在CheckCodeServlet中生成验证码的时候，将验证码数据存入Session对象；
*           (2)前端将验证码和注册数据提交到后台，交给RegisterServlet类；
*           (3)RegisterServlet类接收到请求和数据后，其中就有验证码，和Session中的验证码进行对比；
*           (4)如果一致，则完成注册，如果不一致，则提示错误信息
*
*
*
*  需求
*       访问服务器资源时，需要先进行登录验证，如果没有登录，则自动跳转到登录页面
*           只需要写一个 Filter ，在该过滤器中进行登陆状态校验即可。而在该 Filter 中逻辑如下：
*               0.判断访问的是否是登录相关资源
*                   是：放行
*                   不是：进行登录验证
*               1.判断用户是否登录：session中是否有user对象
*                   登录：直接放行
*                   未登录：跳转到登录页面，并给出提示信息
* */


}
