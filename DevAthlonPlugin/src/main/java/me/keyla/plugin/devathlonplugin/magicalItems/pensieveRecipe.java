package me.keyla.plugin.devathlonplugin.magicalItems;

import me.keyla.plugin.devathlonplugin.DevAthlonPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class pensieveRecipe {

    private Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);
    private ItemStack item = new ItemStack(Material.LAVA_BUCKET,1);
    public void Pensieve() {

        ItemMeta pensieves = item.getItemMeta();
        pensieves.setDisplayName(ChatColor.AQUA + "Pensieve");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "Use command /magicItems pensieve to get a pensieve");
        pensieves.setLore(lore);
        item.setItemMeta(pensieves);
        ShapedRecipe pensieveR = new ShapedRecipe(item);
        pensieveR.shape(" $ ", "$%$", " $ ");
        pensieveR.setIngredient('$', Material.COBBLESTONE);
        pensieveR.setIngredient('%', Material.FEATHER);
        plugin.getServer().addRecipe(pensieveR);
    }
}
