package com.aptech.dao;

import com.aptech.config.Database;
import com.aptech.models.Category;
import com.aptech.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private static Connection con = Database.connect();

    //return all categories
    public static List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setCreatedAt(rs.getString("created_at"));
                category.setUpdatedAt(rs.getString("updated_at"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    //save category
    public static boolean save(Category category) {
        boolean status = false;
        int check = 0;

        //sql statement
        String sql = "INSERT INTO category(name) VALUES (?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
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

    //get category by id
    public static Category getCategoryById(int categoryId) {
        Category category = null;
        String sql = "SELECT * FROM category WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setCreatedAt(rs.getString("created_at"));
                category.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    //update category by id
    public static int update(Category category) {
        int status = 0;
        String sql = "UPDATE category SET name=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    //delete category
    public static int deleteCategory(int categoryId) {
        String sql = "DELETE FROM category WHERE id=?";
        int status = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryId);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
