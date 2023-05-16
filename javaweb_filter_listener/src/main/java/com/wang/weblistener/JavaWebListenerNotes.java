package com.wang.weblistener;

public class JavaWebListenerNotes {

/**
*
*   Listener 表示监听器，是 JavaWeb 三大组件(Servlet、Filter、Listener)之一。
*   监听器可以监听就是在 application ， session ， request 三个对象创建、销毁或者往其中添加修改删除属性时自动执行代码的功能组件。
*   application 是 ServletContext 类型的对象
*   ServletContext 代表整个web应用，在服务器启动的时候，tomcat会自动创建该对象。在服务器关闭时会自动销毁该对象。
*
*   JavaWeb 提供了8个监听器：
*       JavaWeb 提供了8个监听器：
*           【ServletContext监听】:只需要学这两个
*                    ServletContextListener:用于对ServletContext对象进行监听（创建、销毁）
*                    ServletContextAttributeListener:对ServletContexti对象中属性的监听（增删改属性）
*
*           【Session监听】
*                    HttpSessionListener:对Session对象的整体状态的监听（创建、销毁）
*                    HttpSessionAttributeListener:对Session对象中的属性监听（增删改属性）
*                    HttpSessionBindingListener:监听对象于Session的绑定和解除
*                    HttpSessionActivationListener:对Session数据的钝化和活化的监听
*
*           【Request监听】
*                    ServletRequestListener:对Requesti对象进行监听（创建、销毁）
*                    ServletRequestAttributeListener:对Requesti对象中属性的监听（增删改属性）
*
*       这里面只有 ServletContextListener 这个监听器后期我们会接触到， ServletContextListener 是用来监听ServletContext 对象的创建和销毁。
*       ServletContextListener 接口中有以下两个方法:
*               void contextInitialized(ServletContextEvent sce) ： ServletContext 对象被创建了会自动执行的方法;
*               void contextDestroyed(ServletContextEvent sce) ： ServletContext 对象被销毁时会自动执行的方法;
*
* */

}

