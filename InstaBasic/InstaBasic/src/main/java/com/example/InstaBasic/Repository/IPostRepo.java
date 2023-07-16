package com.example.InstaBasic.Repository;


import com.example.InstaBasic.Model.Post;
import com.example.InstaBasic.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepo extends JpaRepository<Post, Integer> {


    List<Post> findByUser(User user);
}