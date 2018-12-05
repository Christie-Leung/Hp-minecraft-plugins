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

import java.text.SimpleDateFormat;
import java.util.Date;

import static me.keyla.plugin.devathlonplugin.magicalItems.customItems.memoryBottle;

public class eventListener implements Listener {
    Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);

    @EventHandler
    public void acquireBofMemories(PlayerInteractEntityEvent event) {
        Player p = event.getPlayer();
        Entity e = event.getRightClicked();

            //Acquire Bottle of Memories
            if (event.getHand().equals(EquipmentSlot.HAND)) {
                if (p.getItemInHand().getType() == Material.GLASS_BOTTLE && e instanceof Player) {

                    Player clickedPlayer = (Player) e;
                    p.getInventory().addItem(memoryBottle);
                    ItemStack hand = p.getInventory().getItemInHand();
                    hand.setAmount(hand.getAmount() - 1);
                    p.getInventory().setItemInHand(hand);
                    p.sendMessage( ChatColor.DARK_AQUA + "You got a memory of " + clickedPlayer);
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
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("[dd-MM-yyyy HH:mm:ss]");

        if (!msg.isEmpty()) {
            plugin.getConfig().set(format.format(now) + p.getName() + "", msg);
            plugin.saveConfig();
        }
    }

}
