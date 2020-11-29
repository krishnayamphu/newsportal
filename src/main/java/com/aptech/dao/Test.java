package com.aptech.dao;

import com.aptech.models.Category;
import com.aptech.models.User;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Category> users=CategoryDao.getAllCategories();
        for (Category u:users) {
            System.out.println(u.getName());
        }
    }
}
