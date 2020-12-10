package com.aptech.dao;

import com.aptech.models.Category;
import com.aptech.models.Post;
import com.aptech.models.User;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Post post=new Post();
        post.setTitle("Hello World");
        post.setText("sample post content.");
        post.setImage("pic.jpg");
        post.setCategory(1);
        PostDao.save(post);
    }
}
