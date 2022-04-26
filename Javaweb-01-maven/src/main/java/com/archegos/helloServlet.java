package com.archegos;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class helloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* PrintWriter writer = resp.getWriter();
        writer.print("Hello Servlet");*/
        ServletContext context = this.getServletContext();

        String username = "张之路";//数据
        context.setAttribute("myusername",username);//将一个数据保存在了ServletContext中，名字为：myusername 。值 username
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
