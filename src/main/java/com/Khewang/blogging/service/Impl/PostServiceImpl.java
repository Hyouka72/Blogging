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
import java.util.stream.Collectors;

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
    public List<PostDto> getAllPost() {

        List<Post> posts =  this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((post )-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","PostId", postId));

        return this.modelMapper.map(post, PostDto.class);


    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","category id", categoryId) );

        List<Post> posts =  this.postRepo.findByCategory(cat);

        List<PostDto> postDtos = posts.stream().map((Post)-> this.modelMapper.map(Post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","UserID", userId));

        List<Post> posts = this.postRepo.findByUser(user);

        List<PostDto> PostDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return PostDtos;
    }

    @Override
    public List<Post> searchPosts(String Keyword) {
        return List.of();
    }
}
