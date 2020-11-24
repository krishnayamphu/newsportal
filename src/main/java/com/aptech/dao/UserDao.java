package com.aptech.dao;

import com.aptech.config.Database;
import com.aptech.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private static Connection con = Database.connect();
    //save user
    public static boolean save(User user) {
        boolean status = false;
        int check = 0;

        //sql statement
        String sql = "INSERT INTO users(username,email,password) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3,user.getPassword());
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

}
