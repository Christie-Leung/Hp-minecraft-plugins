package me.keyla.plugin.devathlonplugin.magicalItems;

import me.keyla.plugin.devathlonplugin.DevAthlonPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;

import static me.keyla.plugin.devathlonplugin.magicalItems.customItems.weasleyClock;

public class WeasleyClock implements Listener {

    private Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);
    private Boolean active = false;

    @EventHandler
    public void clockRightClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        Block clickedBlock = e.getClickedBlock();
        if (clickedBlock != null) {
                if (e.getHand().equals(EquipmentSlot.HAND)) {
                    if (p.getItemInHand().isSimilar(weasleyClock)) {
                        p.sendMessage(ChatColor.DARK_AQUA + "Who's location would you like to know?");
                        active = true;
                    }
                }
            }
    }

    @EventHandler
    public void getDesginatedPlayer(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (active = true) {
            String msg = e.getMessage();
            p.sendMessage(ChatColor.BLUE + "Online Players:");
            for (Player p2 : plugin.getServer().getOnlinePlayers()) {
                p.sendMessage(ChatColor.GOLD + p2.getName());
            }
                for (Player p2 : plugin.getServer().getOnlinePlayers()) {
                    if (msg.equalsIgnoreCase(p2.getName())) {
                        Location p_loc = p2.getLocation();
                        p.sendMessage(ChatColor.YELLOW +
                                "X: " + p_loc.getBlockX() +
                                "\nY: " + p_loc.getBlockY() +
                                "\nZ: " + p_loc.getBlockZ());
                    }
                }
        }
        active = false;
    }
}

