package com.aptech.controllers.user;

import com.aptech.dao.UserDao;
import com.aptech.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/register")
public class UserRegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password =request.getParameter("password");

        User user=new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
//        PrintWriter pw=response.getWriter();
//        pw.println("hello");
        UserDao.save(user);

        response.sendRedirect("/newsportal/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }
}
