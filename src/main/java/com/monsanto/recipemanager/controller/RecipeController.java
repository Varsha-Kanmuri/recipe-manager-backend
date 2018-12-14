package com.monsanto.recipemanager.controller;

import com.monsanto.recipemanager.model.Recipe;
import com.monsanto.recipemanager.service.impl.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeServiceImpl recipeService;

    @CrossOrigin
    @GetMapping("/fetchRecipies")
    public List<Recipe> fetchRecipies() {
        return recipeService.fetchRecipes();
    }

    @CrossOrigin
    @PostMapping("/addRecipe")
    public Recipe addRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @CrossOrigin
    @GetMapping("/fetchRecipie/{id}")
    public Recipe getRecipeById(@PathVariable(value = "id") int recipeId) {
        return recipeService.findById(recipeId);
    }
}
