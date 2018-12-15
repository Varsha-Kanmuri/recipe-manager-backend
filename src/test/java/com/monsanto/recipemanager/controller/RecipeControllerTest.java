package com.monsanto.recipemanager.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monsanto.recipemanager.model.Recipe;
import com.monsanto.recipemanager.service.impl.RecipeServiceImpl;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RecipeController.class)
public class RecipeControllerTest {


    @MockBean
    RecipeServiceImpl recipeService;

    @Autowired
    private MockMvc mvc;


    RecipeController recipeController = new RecipeController();

    @Test
    public void testShould_fetch_all_recipes()
            throws Exception {

        List<Recipe> recipeList = new ArrayList<Recipe>();
        String recipeItems1[] = {"salt", "pepper", "garlic", "bread"};
        Recipe recipe1 = new Recipe();
        Set<String> items1 = new HashSet<String>(Arrays.asList(recipeItems1));
        recipe1.setRecipeId(1);
        recipe1.setRecipeName("Garlic Bread");
        recipe1.setItems(items1);
        recipeList.add(recipe1);

        String recipeItems2[] = {"dough", "olives", "red pepper", "onions"};
        Recipe recipe2 = new Recipe();
        Set<String> items2 = new HashSet<String>(Arrays.asList(recipeItems2));
        recipe2.setRecipeId(2);
        recipe2.setRecipeName("Pizza");
        recipe2.setItems(items2);
        recipeList.add(recipe2);


        Mockito.when(recipeService.fetchRecipes()).thenReturn(recipeList);

        mvc.perform(get("/fetchRecipies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].recipeId", is(1)))
                .andExpect(jsonPath("$.[0].recipeName", is("Garlic Bread")))
                .andExpect(jsonPath("$.[1].recipeId", is(2)))
                .andExpect(jsonPath("$.[1].recipeName", is("Pizza")));

    }

    @Test
    public void testShould_get_recipe()
            throws Exception {


        List<Recipe> recipeList = new ArrayList<Recipe>();

        System.out.println("p" + this.recipeService);
        String recipeItems1[] = {"salt", "pepper", "garlic", "bread"};
        Recipe recipe1 = new Recipe();
        Set<String> items1 = new HashSet<String>(Arrays.asList(recipeItems1));
        recipe1.setRecipeId(1);
        recipe1.setRecipeName("Garlic Bread");
        recipe1.setItems(items1);
        recipeList.add(recipe1);

        Mockito.when(recipeService.findById(1)).thenReturn(recipeList.get(0));

        mvc.perform(get("/fetchRecipie/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.recipeId", is(1)))
                .andExpect(jsonPath("$.recipeName", is("Garlic Bread")));


    }

    @Test
    public void testShould_add_recipe()
            throws Exception {


        List<Recipe> recipeList = new ArrayList<Recipe>();
        
        String recipeItems1[] = {"salt", "pepper", "garlic", "bread"};
        Recipe recipe1 = new Recipe();
        Set<String> items1 = new HashSet<String>(Arrays.asList(recipeItems1));
        recipe1.setRecipeId(1);
        recipe1.setRecipeName("Garlic Bread");
        recipe1.setItems(items1);
        recipeList.add(recipe1);

        Mockito.when(recipeService.createRecipe(recipe1)).thenReturn(recipeList.get(0));

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);


        mvc.perform(post("/addRecipe")
                .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(recipe1)))
                .andExpect(status().isOk());

    }
}
