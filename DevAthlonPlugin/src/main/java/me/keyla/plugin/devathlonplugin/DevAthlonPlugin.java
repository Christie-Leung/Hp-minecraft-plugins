package me.keyla.plugin.devathlonplugin;

import me.keyla.plugin.devathlonplugin.Events.eventListener;
import me.keyla.plugin.devathlonplugin.magicalItems.WeasleyClock;
import me.keyla.plugin.devathlonplugin.magicalItems.memories;
import me.keyla.plugin.devathlonplugin.magicalItems.pensieveRecipe;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class DevAthlonPlugin extends JavaPlugin implements Listener {

    public void onEnable() {

        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "\nWorking\n");
        getServer().getPluginManager().registerEvents(new eventListener(), this);
        getServer().getPluginManager().registerEvents(new memories(), this);
        getServer().getPluginManager().registerEvents(new WeasleyClock(), this);
        loadConfig();

        pensieveRecipe pR = new pensieveRecipe();
        pR.Pensieve();

        this.getCommand("magicItems").setExecutor(new magicItems());
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "\nNot Working\n");
        getServer().clearRecipes();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


}