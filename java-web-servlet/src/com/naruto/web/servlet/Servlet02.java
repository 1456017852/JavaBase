package com.naruto.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName: Servlet01
 * @Description: Servlet3.0 @WebServlet配置servlet，使用了@WebServlet注解，Web.xml中的servlet配置失效
 * @Author: naruto
 * @Date: 2019/10/10 23:58
 */
@WebServlet(value = "/servlet02",loadOnStartup = 1,asyncSupported = true)
public class Servlet02 implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("hello servlet3.0 init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("hello servlet3.0 service");
        System.out.println("hello servlet3.0 service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("hello servlet3.0 destory");
    }
}
