package com.Khewang.blogging.repository;

import com.Khewang.blogging.model.Category;
import com.Khewang.blogging.model.Post;
import com.Khewang.blogging.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
