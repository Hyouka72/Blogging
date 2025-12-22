package com.Khewang.blogging.service;

import com.Khewang.blogging.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer PostId);

    void deleteComment(Integer commentId);
}
