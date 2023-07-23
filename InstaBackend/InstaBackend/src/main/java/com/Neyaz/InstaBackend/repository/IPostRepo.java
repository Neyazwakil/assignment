package com.Neyaz.InstaBackend.repository;

import com.Neyaz.InstaBackend.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
