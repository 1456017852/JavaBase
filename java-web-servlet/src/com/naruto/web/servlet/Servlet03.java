package com.naruto.web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName: Servlet03
 * @Description: servlet的体系结构
 *
 *          servlet: 接口
 *              |实现
 *          GenericServlet: 抽象类，将servlet中除了service()外的其他房方法都做了空实现，只将service()方法抽象
 *              |继承
 *          HttpServlet: 抽象类，是对http协议的封装的servlet，详情查看Servlet04
 * @Author: naruto
 * @Date: 2019/10/11 0:23
 */
@WebServlet("/servlet03")
public class Servlet03 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("hello GenericServlet");
        System.out.println("hello GenericServlet");
    }
}
