package com.aptech.controllers.posts;

import com.aptech.dao.CategoryDao;
import com.aptech.dao.PostDao;
import com.aptech.models.Category;
import com.aptech.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/posts")
public class PostsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDao.deletePost(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/newsportal/posts");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts= PostDao.getAllPosts();
        List<Category> categories= CategoryDao.getAllCategories();
        request.setAttribute("posts",posts);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("posts/posts.jsp").forward(request,response);
    }
}
