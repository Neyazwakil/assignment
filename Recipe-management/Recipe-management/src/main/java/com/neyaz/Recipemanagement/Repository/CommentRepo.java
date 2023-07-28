package com.neyaz.Recipemanagement.Repository;

import com.neyaz.Recipemanagement.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
