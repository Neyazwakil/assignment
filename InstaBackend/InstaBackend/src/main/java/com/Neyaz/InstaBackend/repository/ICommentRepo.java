package com.Neyaz.InstaBackend.repository;

import com.Neyaz.InstaBackend.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment,Integer> {
}
