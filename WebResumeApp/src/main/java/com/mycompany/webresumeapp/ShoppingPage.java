/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.webresumeapp;

import entity.User;
import inter.UserInterDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.Context;

/**
 *
 * @author Plague
 */
@WebServlet(name = "ShoppingPage", urlPatterns = {"/ShoppingPage"})
public class ShoppingPage extends HttpServlet {

    UserInterDao userDao = Context.instanceUserDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BS ShoppingPage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome to BS shopping </h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = userDao.getAll(null,null,null);
        String name = request.getParameter("name");
        System.out.println(name);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                processRequest(request, response);
                break;
            }
            if (i == users.size() - 1) {
                PrintWriter out = response.getWriter();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>BS ShoppingPage</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Login failed</h1>");
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println(name);
        System.out.println(surname);
        User u = userDao.getUserById(1);
        u.setName(name);
        u.setSurname(surname);
        userDao.updateUser(u);
        PrintWriter out = response.getWriter();
        out.println("<p>User was updated successfully</p>");

        response.sendRedirect("user.jsp");
    }

}
