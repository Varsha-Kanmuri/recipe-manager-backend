package com.monsanto.recipemanager.repository;

import com.monsanto.recipemanager.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

}
