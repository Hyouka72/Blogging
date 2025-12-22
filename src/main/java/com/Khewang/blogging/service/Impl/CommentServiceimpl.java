package com.Khewang.blogging.service.Impl;

import com.Khewang.blogging.exception.ResourceNotFoundException;
import com.Khewang.blogging.model.Comment;
import com.Khewang.blogging.model.Post;
import com.Khewang.blogging.payload.CommentDto;
import com.Khewang.blogging.repository.CommentRepository;
import com.Khewang.blogging.repository.PostRepository;
import com.Khewang.blogging.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceimpl implements CommentService {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentDto createComment(CommentDto commentDto, Integer PostId) {
        Post post = this.postRepo.findById(PostId).orElseThrow(() -> new ResourceNotFoundException("Post","PostId",PostId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);

        Comment savedComment =  this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);

    }
    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "CommentId", commentId));
        commentRepo.delete(com);
    }
}
