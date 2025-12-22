package com.Khewang.blogging.controller;


import com.Khewang.blogging.payload.ApiResponse;
import com.Khewang.blogging.payload.CommentDto;
import com.Khewang.blogging.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> PostComment(@RequestBody CommentDto comment,
                                                  @PathVariable Integer postId){
       CommentDto createComment =  this.commentService.createComment(comment, postId);
       return new ResponseEntity<>(createComment, HttpStatus.CREATED);

    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment Successfully Deleted", true), HttpStatus.OK);
    }
}
