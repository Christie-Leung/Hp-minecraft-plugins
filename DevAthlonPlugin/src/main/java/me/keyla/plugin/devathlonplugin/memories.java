package me.keyla.plugin.devathlonplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static me.keyla.plugin.devathlonplugin.customItems.memoryBottle;

public class memories implements Listener {

    public void playerMemories() {



        ItemMeta mb = customItems.memoryBottle.getItemMeta();
        {
            mb.setDisplayName(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Bottle of Memories");
            mb.setLore(Arrays.asList(ChatColor.DARK_BLUE + "I wonder whats inside this"));
            memoryBottle.setItemMeta(mb);
        }
    }
}


