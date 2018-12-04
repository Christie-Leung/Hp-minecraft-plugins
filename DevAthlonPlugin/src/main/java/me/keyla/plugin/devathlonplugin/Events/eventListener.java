package me.keyla.plugin.devathlonplugin.Events;

import me.keyla.plugin.devathlonplugin.DevAthlonPlugin;
import me.keyla.plugin.devathlonplugin.magicalItems.memories;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import static me.keyla.plugin.devathlonplugin.magicalItems.customItems.memoryBottle;

public class eventListener implements Listener {
    Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);
    private int count;


    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        Location b_loc = block.getLocation();
        player.sendMessage(ChatColor.BLUE + "You broke: " + ChatColor.AQUA + block.getType().toString().toUpperCase());
        player.sendMessage(ChatColor.BLUE + "Location:");
        player.sendMessage(ChatColor.BLUE + "World: " + ChatColor.WHITE + b_loc.getWorld().getName());
        player.sendMessage(ChatColor.BLUE + "X: " + ChatColor.WHITE + b_loc.getBlockX());
        player.sendMessage(ChatColor.BLUE + "Y: " + ChatColor.WHITE + b_loc.getBlockY());
        player.sendMessage(ChatColor.BLUE + "Z: " + ChatColor.WHITE + b_loc.getBlockZ());

    }

 /*   @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        Location b_loc = block.getLocation();
        player.sendMessage(ChatColor.GOLD + "You Placed: " + ChatColor.LIGHT_PURPLE + block.getType().toString().toUpperCase());
        player.sendMessage(ChatColor.GOLD + "Location:");
        player.sendMessage(ChatColor.GOLD + "World: " + ChatColor.WHITE + b_loc.getWorld().getName());
        player.sendMessage(ChatColor.GOLD + "X: " + ChatColor.WHITE + b_loc.getBlockX());
        player.sendMessage(ChatColor.GOLD + "Y: " + ChatColor.WHITE + b_loc.getBlockY());
        player.sendMessage(ChatColor.GOLD + "Z: " + ChatColor.WHITE + b_loc.getBlockZ());

        if (block.getType().equals(Material.TNT)) {
            plugin.getServer().broadcastMessage(ChatColor.GREEN + ">>>>> " + player.getName() + " Placed: " + ChatColor.LIGHT_PURPLE + block.getType().toString().toUpperCase());
        }
    }
*/

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        Location b_loc = block.getLocation();
        if (block.getType().equals(Material.TNT)) {
            player.sendMessage(ChatColor.RED + "Placing TNT has added you to out logs!");
            plugin.getConfig().set("\nUsers." + player.getUniqueId() + ".Block_" + count + ".World",
                    b_loc.getWorld().getName());
            plugin.getConfig().set("\nUsers." + player.getUniqueId() + ".Block_" + count + ".X", b_loc.getBlockX());
            plugin.getConfig().set("\nUsers." + player.getUniqueId() + ".Block_" + count + ".Y", b_loc.getBlockY());
            plugin.getConfig().set("\nUsers." + player.getUniqueId() + ".Block_" + count + ".Z", b_loc.getBlockZ());
            plugin.saveConfig();
            count++;
        }
    }


    @EventHandler
    public void acquireBofMemories(PlayerInteractEntityEvent event) {
        Player p = event.getPlayer();
        Entity e = event.getRightClicked();

            //Acquire Bottle of Memories
            if (event.getHand().equals(EquipmentSlot.HAND)) {
                if (p.getItemInHand().getType() == Material.GLASS_BOTTLE && e instanceof Player) {

                    Player clickedPlayer = (Player) e;
                    p.sendMessage("Test: You clicked " + clickedPlayer.getName());
                    p.getInventory().addItem(memoryBottle);
                    ItemStack hand = p.getInventory().getItemInHand();
                    hand.setAmount(hand.getAmount() - 1);
                    p.getInventory().setItemInHand(hand);
                    memories m = new memories();
                    m.playerMemories();

                } else {
                    p.sendMessage(ChatColor.RED + "You must have a glass bottle in your hand!");
                }
            }
        }


    @EventHandler
        public void onChatSave(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        String msg = event.getMessage();

        plugin.getConfig().set(p.getName() + " ",msg);
        plugin.saveConfig();
    }

    }
