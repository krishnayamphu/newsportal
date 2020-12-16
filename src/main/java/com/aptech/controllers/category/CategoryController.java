package com.aptech.controllers.category;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao.deleteCategory(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/newsportal/category");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories= CategoryDao.getAllCategories();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("category/category.jsp").forward(request,response);
    }
}
