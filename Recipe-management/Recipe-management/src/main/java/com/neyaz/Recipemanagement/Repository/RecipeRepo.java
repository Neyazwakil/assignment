package com.neyaz.Recipemanagement.Repository;

import com.neyaz.Recipemanagement.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe,Long> {

}

