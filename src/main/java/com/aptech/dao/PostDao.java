package com.aptech.dao;

import com.aptech.config.Database;
import com.aptech.models.Category;
import com.aptech.models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    private static Connection con = Database.connect();

    //return all posts
    public static List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setCategory(rs.getInt("category"));
                post.setTitle(rs.getString("title"));
                post.setText(rs.getString("text"));
                post.setImage(rs.getString("image"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    //save post
    public static boolean save(Post post) {
        boolean status = false;
        int check = 0;

        //sql statement
        String sql = "INSERT INTO posts(title,text,image,category) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getText());
            ps.setString(3, post.getImage());
            ps.setInt(4, post.getCategory());
            check = ps.executeUpdate(); //1/0
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (check == 1) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    //get post by id
    public static Post getCategoryById(int postId) {
        Post post = null;
        String sql = "SELECT * FROM posts WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, postId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setText(rs.getString("text"));
                post.setCategory(rs.getInt("category"));
                post.setImage(rs.getString("image"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    //update post by id
    public static int update(Post post) {
        int status = 0;
        String sql = "UPDATE post SET title=?,text=?,category=?,image=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getText());
            ps.setInt(3,post.getCategory());
            ps.setString(4,post.getImage());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    //delete post
    public static int deletePost(int postId) {
        String sql = "DELETE FROM posts WHERE id=?";
        int status = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, postId);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
