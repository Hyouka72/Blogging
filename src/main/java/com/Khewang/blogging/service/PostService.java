package com.Khewang.blogging.service;

import com.Khewang.blogging.model.Post;
import com.Khewang.blogging.payload.PostDto;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all posts

    List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);

    //get single post

    PostDto getPostById(Integer postId);


    //get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //search post by keyword
    List<Post> searchPosts(String Keyword);
}
