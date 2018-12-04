package me.keyla.plugin.devathlonplugin;

import me.keyla.plugin.devathlonplugin.magicalItems.customItems;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static me.keyla.plugin.devathlonplugin.magicalItems.customItems.weasleyClock;

public class magicItems implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                p.sendMessage(ChatColor.GOLD + "Pensieve, WeasleyClock");
                return true;
            }

            if (args[0].equalsIgnoreCase("WeasleyClock")) {
                p.getInventory().addItem(weasleyClock);
                p.sendMessage(ChatColor.GREEN + "You got a Weasley clock");
            }

            if (args[0].equalsIgnoreCase("Pensieve")) {
                p.sendMessage(ChatColor.LIGHT_PURPLE + "How to make Pensieve: " + ChatColor.GRAY + "\n Space - Cobblestone - Space \n Cobblestone - Feather - CobbleStone \n Space - Cobblestone - Space ");
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

