package com.neyaz.Recipemanagement.Service;

import com.neyaz.Recipemanagement.Model.Recipe;
import com.neyaz.Recipemanagement.Model.User;
import com.neyaz.Recipemanagement.Repository.AuthenticationRepo;
import com.neyaz.Recipemanagement.Repository.RecipeRepo;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Service
public class RecipeService {
    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    AuthenticationRepo authenticationRepo;

    public String createRecipe(Recipe recipe) {
        recipe.setRecipeCreatedTimeStamp(LocalDateTime.now());
        recipeRepo.save(recipe);
        return "recipe uploaded!!!!";
    }

    public String removeRecipe(Long recipeId, User user) {

        Recipe recipe  = recipeRepo.findById(recipeId).orElse(null);
        if(recipe != null && recipe.getPostOwner().equals(user))
        {
            recipeRepo.deleteById(recipeId);
            return "Removed successfully";
        }
        else if (recipe == null)
        {
            return "recipe to be deleted does not exist";
        }
        else{
            return "Un-Authorized delete detected....Not allowed";
        }
    }

    public boolean validateRecipe(Recipe recipe) {
        return (recipe!=null && recipeRepo.existsById(recipe.getRecipeId()));
    }


    public Recipe getRecipeById(Long id) {
        return recipeRepo.findById(id).orElse(null);
    }
    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }


}
