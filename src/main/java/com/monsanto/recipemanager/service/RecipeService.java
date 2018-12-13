package com.monsanto.recipemanager.service;

import com.monsanto.recipemanager.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {

    List<Recipe> fetchRecipes();
    Recipe createRecipe(Recipe recipe);
    Recipe findById(int recipeId);
}
