package com.monsanto.recipemanager.controller;

import com.monsanto.recipemanager.model.Recipe;
import com.monsanto.recipemanager.service.RecipeService;
import com.monsanto.recipemanager.service.impl.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeServiceImpl recipeService;

    @GetMapping("/fetchRecipies")
    public List<Recipe> fetchRecipies() {
        return recipeService.fetchRecipes();
    }

    @PostMapping("/addRecipe")
    public Recipe addRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/fetchRecipie/{id}")
    public Recipe getRecipeById(@PathVariable(value = "id") int recipeId) {
        return recipeService.findById(recipeId);
    }
}
