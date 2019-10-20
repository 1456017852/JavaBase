package com.naruto.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: Cookie02
 * @Description: TODO
 * @Author: naruto
 * @Date: 2019/10/17 22:34
 */
@WebServlet("/cookie02")
public class Cookie02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Cookie[] cookies=req.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName()+":"+cookie.getValue());
//        }
        Cookie c3=new Cookie("msg3","HelloCookie-03");
        Cookie c4=new Cookie("msg4","HelloCookie-04");
        resp.addCookie(c3);
        resp.addCookie(c4);
        resp.getWriter().write("Hello Cookie!");
    }
}
