package com.naruto.web.cookie;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: Cookie01
 * @Description: Cookie的快速入门你
 *      创建Cookie,绑定数据
 *      发送Cookie到客户端
 *      获取Cookie,拿到数据
 * @Author: naruto
 * @Date: 2019/10/17 22:26
 */
@WebServlet("/cookie01")
public class Cookie01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("msg1","HelloCookie-01");
        cookie.setMaxAge(30);//将cookie持久化到硬盘，30s后删除
        resp.addCookie(cookie);
        resp.getWriter().write("Hello Cookie!");
    }
}
