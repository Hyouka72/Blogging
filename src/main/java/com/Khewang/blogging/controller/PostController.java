package com.Khewang.blogging.controller;

import com.Khewang.blogging.model.Post;
import com.Khewang.blogging.payload.ApiResponse;
import com.Khewang.blogging.payload.PostDto;
import com.Khewang.blogging.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId){

        PostDto createPost =  this.postService.createPost(postDto, userId, categoryId);
        return  new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser( @PathVariable Integer userId){
        List<PostDto> posts =  this.postService.getPostsByUser(userId);
        return new ResponseEntity<>( posts, HttpStatus.OK);
    };

    //get by categoru
    @GetMapping("/Category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory( @PathVariable Integer categoryId){
        List<PostDto> posts =  this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>( posts, HttpStatus.OK);
    };

    //get all post

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> posts = this.postService.getAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //get post by ID
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto post = this.postService.getPostById(postId);
        return new ResponseEntity<> (post, HttpStatus.OK);
    }

    //Delete Post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletepost(@PathVariable Integer postId){
         this.postService.deletePost(postId);

         return new ApiResponse("Post Successfully deleted.",true);

    }

    //Update Post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId,@Valid @RequestBody PostDto postDto){
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }



}
