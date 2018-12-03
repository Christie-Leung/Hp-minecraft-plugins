package me.keyla.plugin.devathlonplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

public class removeRecipe {

    public void removeDefaultRecipes() {

    Iterator<Recipe> recipes = Bukkit.recipeIterator();
        while (recipes.hasNext()) {
        if (recipes.next().getResult().getType().equals(Material.CAULDRON)) {
            recipes.remove();
        }
    }

}

}
