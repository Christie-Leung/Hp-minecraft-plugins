package me.keyla.plugin.devathlonplugin.magicalItems;

import me.keyla.plugin.devathlonplugin.DevAthlonPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class WeasleyClock implements Listener {

    private Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);
    private static ArrayList<Player> playerCalled = new ArrayList<Player>();
    private Boolean active = false;

    @EventHandler
    public void clockRightClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        Block clickedBlock = e.getClickedBlock();
        if (clickedBlock != null) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (e.getHand().equals(EquipmentSlot.HAND)) {
                    Material type = clickedBlock.getType();
                    if (type == Material.WATCH) {
                        p.sendMessage(ChatColor.DARK_AQUA + "Who's location would you like to know?");
                        active = true;
                        active = false;
                    }
                }
            }
        }
    }

    @EventHandler
    public void getDesginatedPlayer(AsyncPlayerChatEvent e) {

        if (active = true) {
        String msg = e.getMessage();
        for (Player player : Bukkit.getOnlinePlayers()) {
            String p = player.getName();
            if (p == msg) {
                Location p_loc = player.getLocation();
                player.sendMessage(ChatColor.YELLOW + "X" + p_loc.getBlockX() + "Y" + p_loc.getBlockY()
                        + "Z" + p_loc.getBlockZ());
            } else {
                player.sendMessage(ChatColor.RED + "Please enter a correct username");
            }
        }
        }
    }
}
