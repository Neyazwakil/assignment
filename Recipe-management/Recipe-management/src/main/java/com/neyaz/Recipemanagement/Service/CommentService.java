package com.neyaz.Recipemanagement.Service;

import com.neyaz.Recipemanagement.Model.Comment;
import com.neyaz.Recipemanagement.Model.Recipe;
import com.neyaz.Recipemanagement.Repository.CommentRepo;
import com.neyaz.Recipemanagement.Repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    public CommentService(CommentRepo commentRepository, RecipeRepo recipeRepository) {
        this.commentRepo = commentRepository;
        this.recipeRepo = recipeRepository;
    }

    @Autowired
    CommentRepo commentRepo;
    @Autowired
     RecipeRepo recipeRepo;

    public String addComment(Comment comment) {
        comment.setCommentCreationTimeStamp(LocalDateTime.now());
        commentRepo.save(comment);
        return "Comment has been added!!!";
    }

    public Comment findComment(Long commentId) {
        return  commentRepo.findById(commentId).orElse(null);
    }

    public Comment getCommentById(Long commentId) {
        return commentRepo.findById(commentId).orElse(null);
    }

    public void removeComment(Comment comment) {
        commentRepo.delete(comment);
    }


}
