package com.Khewang.blogging.controller;

import com.Khewang.blogging.config.AppConstants;
import com.Khewang.blogging.exception.ResourceNotFoundException;
import com.Khewang.blogging.payload.ApiResponse;
import com.Khewang.blogging.payload.PostDto;
import com.Khewang.blogging.payload.PostResponse;
import com.Khewang.blogging.service.FileService;
import com.Khewang.blogging.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;
    @Value("project.image")
    private String path;

    //create
//    @PostMapping("/user/{userId}/category/{categoryId}/posts")
//    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
//                                              @PathVariable Integer userId,
//                                              @PathVariable Integer categoryId,
//                                              @RequestParam("image")MultipartFile image
//                                                                                ){
//
//        PostDto createPost =  this.postService.createPost(postDto, userId, categoryId, image);
//        return  new ResponseEntity<>(createPost, HttpStatus.CREATED);
//    }

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("image") MultipartFile image,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId)
    {
        PostDto postDto = new PostDto();
        postDto.setTitle(title);
        postDto.setContent(content);

        PostDto createPost = this.postService.createPost(postDto, userId, categoryId, image);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
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
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false)Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
    ){
        PostResponse posts = this.postService.getAllPost(pageNumber,pageSize, sortBy , sortDir);
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

    //search
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTile(
            @PathVariable("keywords") String keywords
    ){
        List<PostDto> result =  this.postService.searchPosts(keywords);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //post image upload

    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(
            @RequestParam("image")MultipartFile image,
            @PathVariable Integer postId
            ) throws IOException {
        PostDto postDto =  this.postService.getPostById(postId);
        String filename =  this.fileService.uploadImage(path, image);



        postDto.setImageName(filename);
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    //method to serve files
    @GetMapping(value = "post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadFile(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
        InputStream resource = this.fileService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    }

}
