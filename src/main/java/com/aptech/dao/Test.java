package com.aptech.dao;

import com.aptech.models.User;

public class Test {
    public static void main(String[] args) {
        User user=new User();
        user.setUsername("admin");
        user.setEmail("admin@gmail.com");
        user.setPassword("a123");

        UserDao.save(user);

        System.out.println("user saved.");
    }
}
