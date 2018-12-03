package me.keyla.plugin.devathlonplugin;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DevAthlonPlugin extends JavaPlugin implements Listener {

    public void onEnable() {

        removeRecipe recipes = new removeRecipe();
        recipes.removeDefaultRecipes();

        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "\nWorking\n");
        getServer().getPluginManager().registerEvents(new eventListener(), this);
        loadConfig();


        customItems items = new customItems();
        items.Pensieve();
      //  items.testBottle();

    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "\nNot Working\n");
        getServer().clearRecipes();
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


}