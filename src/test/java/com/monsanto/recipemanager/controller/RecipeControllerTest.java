package com.monsanto.recipemanager.controller;

/*import com.monsanto.recipemanager.model.Recipe;
import com.monsanto.recipemanager.service.RecipeService;
import com.monsanto.recipemanager.service.impl.RecipeServiceImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RecipeController.class, secure = false)
public class RecipeControllerTest {

    @MockBean
    RecipeServiceImpl recipeService;

    RecipeController recipeController = new RecipeController();

    @Test
    public void testShould_fetch_recipes() {
        List<Recipe> recipeList = new ArrayList<Recipe>();
        Recipe recipe = new Recipe();
        recipe.setRecipeName("Pasta");
        recipe.setRecipeId(1);
        Mockito.when(recipeService.fetchRecipes()).thenReturn(recipeList);
        assertEquals(recipeController.fetchRecipies(), recipeList);
    }
}*/
