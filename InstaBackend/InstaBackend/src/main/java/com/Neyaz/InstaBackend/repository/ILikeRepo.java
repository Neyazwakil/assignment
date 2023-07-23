package com.Neyaz.InstaBackend.repository;

import com.Neyaz.InstaBackend.model.Like;
import com.Neyaz.InstaBackend.model.Post;
import com.Neyaz.InstaBackend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILikeRepo extends JpaRepository<Like,Integer> {

    List<Like> findByInstaPostAndLiker(Post instaPost, User liker);

    List<Like> findByInstaPost(Post validPost);
}
