package com.naruto.web.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName: Servlet01
 * @Description:
 *      1、servlet入门程序
 *      2、servlet执行原理
 *          (1)、项目部署的servlet容器启动时，加载web.xml文件；
 *          (2)、当服务器接收到浏览器的请求后，会解析URL,获取uri,在查找web.xml中配置的servlet全类名；
 *          (3)、servlet容器将对应servlet的字节码文件加载到内存，根据全类名，反射创建对象，并初始化；
 *          (4)、servlet容器将请求信息封装为ServletRequest接口的实例对象，创建ServletResponse接口的实例对象
 *          (4)、将ServletRequest接口的实例对象和ServletResponse接口的实例对象，作为实参传入service()方法，并调用service(),处理请求(ServletRequest)，并设置响应信息（ServletResponse）！
 *          (5)、servlet容器将响应信息返回给浏览器
 *      3、servlet生命周期
 *          init
 *          service
 *          destory
 *
 * @Author: naruto
 * @Date: 2019/10/10 23:58
 */
public class Servlet01 implements Servlet {
    /**
     * servlet的初始化方法：在servlet实例对象被创建时只执行一次
     *
     * servlet的创建时机：
     *  （1）默认情况下,第一次访问该servlet时，jvm加载com.naruto.web.ServletHelloWorld的字节码到内存，创建ServletHelloWorld的实例对象，并初始化
     *  （2）配置：改变servlet的创建时机，在web.xml的<servlet></servlet>中配置<load-on-startup></load-on-startup>
     *      配置的值如果为负整数时：和默认情况相同
     *      配置的值如果为0和正整数时：servlet容器启动时，就加载com.naruto.web.ServletHelloWorld的字节码到内存，创建ServletHelloWorld的实例，并初始化
     *
     * servlet只执行一次init方法，说明内存中，一个servlet只有一个该servlet的实例对象，故而servlet是单例，多线程访问存在线程不安全问题
     *(解决：尽量不要在servlet中定义成员变量，也不要修改成员变量的值)
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("[===========================servlet init==========================]");
        //获取所有servlet初始化的参数
        Enumeration servletConfigInitParams=servletConfig.getInitParameterNames();
        while (servletConfigInitParams.hasMoreElements()){
            System.out.println("servletInitParam:"+servletConfigInitParams.nextElement());
        }
        //获取servlet的上下文对象
        ServletContext servletContext=servletConfig.getServletContext();
        System.out.println("servletContext:"+servletContext);

        //服务器信息
        String serverInfo=servletContext.getServerInfo();
        System.out.println("servletContext---serverInfo:"+serverInfo);

        //获取servlet的名称
        String servletName=servletConfig.getServletName();
        System.out.println("servletName:"+servletName);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * servlet提供服务的方法：接受浏览器发送的Http请求，并将请求信息封装为ServletRequest的实例对象，
     *                      处理请求，并响应浏览器（将响应信息封装为ServletResponse的实例对象）
     *                      每次该servlet被访问时，调用该方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("[===========================servlet service==========================]");
        servletResponse.getWriter().write("hello servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * servlet的销毁方法：servlet容器正常关闭时调用，只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("[===========================servlet destroy==========================]");
    }
}
