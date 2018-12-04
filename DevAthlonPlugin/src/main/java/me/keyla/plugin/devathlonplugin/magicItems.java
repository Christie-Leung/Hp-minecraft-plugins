package me.keyla.plugin.devathlonplugin;

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
import static me.keyla.plugin.devathlonplugin.magicalItems.customItems.weasleyClock;

public class magicItems implements CommandExecutor {

    private Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);
    private ItemStack item = new ItemStack(Material.WATER_BUCKET, 1);
    private int amount = 1;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                p.sendMessage(ChatColor.GOLD + "Pensieve, WeasleyClock");
                return true;
            }

            if (args[0].equalsIgnoreCase("Pensieve")) {
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
                if (p.getInventory().getItem(amount).isSimilar(item)) {
                    // code if they do have the required items
                    p.getInventory().remove(item);
                    p.getInventory().addItem(actualPensieve);
                } else {
                    //code if they do NOT have the required items. If you wish to send them a message saying the items they need use:
                    p.sendMessage(ChatColor.GOLD + "You need to have " + ChatColor.DARK_RED + "1 Pensieve to launch.");
                }
            }

                if (args[0].equalsIgnoreCase("WeasleyClock")) {
                    p.getInventory().addItem(weasleyClock);
                    p.sendMessage(ChatColor.GREEN + "You got a Weasley clock");
                }

            }
        return true;
    }
    ItemMeta wC = customItems.weasleyClock.getItemMeta();
    {
        wC.setDisplayName(ChatColor.ITALIC + "" + ChatColor.YELLOW + "Weasley Clock");
        wC.setLore(Arrays.asList(ChatColor.WHITE + "Right click this to find out a player's location!"));
        weasleyClock.setItemMeta(wC);
    }
}

