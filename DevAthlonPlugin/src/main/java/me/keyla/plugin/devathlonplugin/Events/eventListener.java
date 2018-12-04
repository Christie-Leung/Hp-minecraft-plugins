package me.keyla.plugin.devathlonplugin.Events;

import me.keyla.plugin.devathlonplugin.DevAthlonPlugin;
import me.keyla.plugin.devathlonplugin.magicalItems.memories;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

        plugin.getConfig().set("\n" + p.getName() + ": " , msg);
        plugin.saveConfig();
    }

    }
