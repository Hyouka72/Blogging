package com.Khewang.blogging.service.Impl;

import com.Khewang.blogging.exception.ResourceNotFoundException;
import com.Khewang.blogging.model.Category;
import com.Khewang.blogging.model.Post;
import com.Khewang.blogging.model.User;
import com.Khewang.blogging.payload.PostDto;
import com.Khewang.blogging.repository.CategoryRepository;
import com.Khewang.blogging.repository.PostRepository;
import com.Khewang.blogging.repository.UserRepository;
import com.Khewang.blogging.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return List.of();
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPosts(String Keyword) {
        return List.of();
    }
}
