package com.Khewang.blogging.service;

import com.Khewang.blogging.model.Post;
import com.Khewang.blogging.payload.PostDto;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    //update
    Post updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all posts

    List<Post> getAllPost();

    //get single post

    Post getPostById(Integer postId);


    //get all post by category
    List<Post> getPostsByCategory(Integer categoryId);

    //get all posts by user
    List<Post> getPostsByUser(Integer userId);

    //search post by keyword
    List<Post> searchPosts(String Keyword);
}
