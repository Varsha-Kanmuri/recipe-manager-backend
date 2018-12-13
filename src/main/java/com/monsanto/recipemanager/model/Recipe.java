package com.monsanto.recipemanager.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue//(strategy= GenerationType.AUTO)
    int recipeId;

    @Column
    String recipeName;

    @ElementCollection
    @CollectionTable(name = "setOfItems")
    private Set<String> items = new HashSet<>();

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public Set<String> getItems() {
        return items;
    }

    public void setItems(Set<String> items) {
        this.items = items;
    }
}
