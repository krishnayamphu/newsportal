package com.aptech.controllers.posts;

import com.aptech.dao.CategoryDao;
import com.aptech.dao.PostDao;
import com.aptech.helpers.MediaHelper;
import com.aptech.models.Category;
import com.aptech.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/posts/create")
public class PostCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post=new Post();
        post.setTitle(request.getParameter("title"));
        post.setText(request.getParameter("text"));
        post.setImage(request.getParameter("image"));
        post.setCategory(Integer.parseInt(request.getParameter("category")));
        PostDao.save(post);
        response.sendRedirect("/newsportal/posts");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MediaHelper mediaHelper=new MediaHelper(getServletContext());
        request.setAttribute("images",mediaHelper.getMediaList());
        request.setAttribute("categories",CategoryDao.getAllCategories());
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }
}
