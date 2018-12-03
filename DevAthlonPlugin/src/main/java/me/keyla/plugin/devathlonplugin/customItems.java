package me.keyla.plugin.devathlonplugin;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class customItems {
    private Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);

    private ItemStack item = new ItemStack(Material.BONE,1);
    public void Pensieve() {
        //Pensieve Recipe
        /*ItemMeta pensieves = item.getItemMeta();
        pensieves.setDisplayName(ChatColor.AQUA + "Pensieve");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "Used by Zeus in the great god battle");
        pensieves.setLore(lore);
        item.setItemMeta(pensieves);
        ShapedRecipe pensieveR = new ShapedRecipe(item);
        pensieveR.shape("   ", "*$*", "   ");
        pensieveR.setIngredient('*', Material.COBBLESTONE);
        pensieveR.setIngredient('$', Material.EMERALD);
*/
        ItemMeta pensieves = item.getItemMeta();
        pensieves.setDisplayName(ChatColor.AQUA + "Pensieve");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "Used by Zeus in the great god battle");
        pensieves.setLore(lore);
        item.setItemMeta(pensieves);
        ShapedRecipe pensieveR = new ShapedRecipe(item);
        pensieveR.shape(" $ ", "$%$", " $ ");
        pensieveR.setIngredient('$', Material.STICK);
        pensieveR.setIngredient('%', Material.FEATHER);
        plugin.getServer().addRecipe(pensieveR);

    }
   /* private ItemStack bottle = new ItemStack(Material.EXP_BOTTLE, 1);
    public void testBottle() {
        //Special Bottle Recipe
        ItemMeta expBottle = bottle.getItemMeta();
        expBottle.setDisplayName(org.bukkit.ChatColor.AQUA + "Test bottle");
        ArrayList<String> blore = new ArrayList<String>();
        blore.add(org.bukkit.ChatColor.WHITE + "Have some luck");
        expBottle.setLore(blore);
        bottle.setItemMeta(expBottle);
        ShapedRecipe bottleRecipe = new ShapedRecipe(bottle);
        bottleRecipe.shape(" S ", "SES", " S ");
        bottleRecipe.setIngredient('S', Material.SUGAR);
        bottleRecipe.setIngredient('E', Material.GLASS_BOTTLE);

        plugin.getServer().addRecipe(bottleRecipe);
    }*/

    public static ItemStack memoryBottle = new ItemStack(Material.POTION);
}
