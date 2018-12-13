package com.monsanto.recipemanager.service.impl;

import com.monsanto.recipemanager.model.Recipe;
import com.monsanto.recipemanager.repository.RecipeRepository;
import com.monsanto.recipemanager.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {


    @Autowired
    RecipeRepository recipeRepository;
    public List<Recipe> fetchRecipes() {
        createInitRecipeList();
        return recipeRepository.findAll();

    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe findById(int recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    public void createInitRecipeList() {

        String recipeItems1[] = {"salt", "pepper", "garlic", "bread"};
        String recipeItems2[] = {"dough", "olives", "red pepper", "onions"};
        String recipeItems3[] = {"tomato", "cheese", "bread"};

        Recipe recipe1 = new Recipe();
        Set<String> items1 = new HashSet<String>(Arrays.asList(recipeItems1));
        recipe1.setRecipeId(1);
        recipe1.setRecipeName("Garlic Bread");
        recipe1.setItems(items1);

        recipeRepository.save(recipe1);

        Recipe recipe2 = new Recipe();
        Set<String> items2 = new HashSet<String>(Arrays.asList(recipeItems2));
        recipe2.setRecipeId(2);
        recipe2.setRecipeName("Pizza");
        recipe2.setItems(items2);

        recipeRepository.save(recipe2);

        Recipe recipe3 = new Recipe();
        Set<String> items3 = new HashSet<String>(Arrays.asList(recipeItems3));
        recipe3.setRecipeId(3);
        recipe3.setRecipeName("Sandwich");
        recipe3.setItems(items3);

        recipeRepository.save(recipe3);

    }
}
