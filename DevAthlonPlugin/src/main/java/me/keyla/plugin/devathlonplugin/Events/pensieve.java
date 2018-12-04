package me.keyla.plugin.devathlonplugin.Events;

import me.keyla.plugin.devathlonplugin.DevAthlonPlugin;
import me.keyla.plugin.devathlonplugin.magicalItems.customItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;

import static me.keyla.plugin.devathlonplugin.magicalItems.customItems.actualPensieve;

public class pensieve implements CommandExecutor {

    private Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);
    private ItemStack item = new ItemStack(Material.WATER_BUCKET, 1);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

                ItemMeta pensieves = item.getItemMeta();
                pensieves.setDisplayName(ChatColor.AQUA + "Pensieve");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(ChatColor.WHITE + "Use command /pensieve to get a pensieve");
                pensieves.setLore(lore);
                item.setItemMeta(pensieves);
                ShapedRecipe pensieveR = new ShapedRecipe(item);
                pensieveR.shape(" $ ", "$%$", " $ ");
                pensieveR.setIngredient('$', Material.COBBLESTONE);
                pensieveR.setIngredient('%', Material.EMERALD);
                plugin.getServer().addRecipe(pensieveR);
                if (p.getInventory().contains(Material.matchMaterial(plugin.getConfig().getString(ChatColor.AQUA + "Pensieve")))) {
                    // code if they do have the required items
                    p.getInventory().remove(item);
                    p.getInventory().addItem(actualPensieve);
                    ItemMeta aP = customItems.actualPensieve.getItemMeta();
                    {
                        aP.setDisplayName(ChatColor.ITALIC + "" + ChatColor.AQUA + "Pensieve");
                        aP.setLore(Arrays.asList(ChatColor.DARK_BLUE + "Right click a" + ChatColor.LIGHT_PURPLE + " Bottle of Memories " + ChatColor.DARK_BLUE + "against this."));
                        actualPensieve.setItemMeta(aP);
                    }

                    return true;
                }
                if (!p.getInventory().contains(Material.matchMaterial(plugin.getConfig().getString(ChatColor.AQUA + "Pensieve")))) {
                    //code if they do NOT have the required items. If you wish to send them a message saying the items they need use:
                    p.sendMessage(ChatColor.GOLD + "You need to have " + ChatColor.DARK_RED + (plugin.getConfig().getInt("1 Pensieve")) + " to launch.");
                    return true;
                }
            }
            return false;
        }
    }

