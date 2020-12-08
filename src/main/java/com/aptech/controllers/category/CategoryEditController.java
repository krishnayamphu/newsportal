package com.aptech.controllers.category;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/edit")
public class CategoryEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        category.setId(Integer.parseInt(request.getParameter("id")));
        category.setName(request.getParameter("name"));
        CategoryDao.update(category);
        response.sendRedirect("/newsportal/category");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = CategoryDao.getCategoryById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("category",category);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }
}
