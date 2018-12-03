package me.keyla.plugin.devathlonplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

import static me.keyla.plugin.devathlonplugin.customItems.memoryBottle;

public class eventListener implements Listener {
    Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        Player p = event.getPlayer();
        Entity e = event.getRightClicked();
        {
            //Acquire Bottle of Memories
            if (event.getHand().equals(EquipmentSlot.HAND)) {
                if (p.getItemInHand().getType() == Material.GLASS_BOTTLE && e instanceof Player) {

                    Player clickedPlayer = (Player) e;
                    p.sendMessage("Test: You clicked " + clickedPlayer.getName());
                    p.getInventory().addItem(memoryBottle);
                    memories m = new memories();
                    m.playerMemories();

                } else {
                    p.sendMessage(ChatColor.RED + "You must have a glass bottle in your hand!");
                }
            }
        }
        }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Block clickedBlock = event.getClickedBlock();

        if (clickedBlock != null) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Player player = event.getPlayer();
                if (!player.isSneaking()) {
                    Material type = clickedBlock.getType();
                    // Interacting with a Cauldron
                    if (type == Material.CAULDRON) {
                        Material materialInHand = event.getMaterial();
                        ItemStack i = event.getItem();

                        if (materialInHand == null || materialInHand == Material.BUCKET) {
                            return;

                        } else if (mb.getDisplayName().equalsIgnoreCase(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Bottle of Memories")) {
                            memories m = new memories();
                            m.playerMemories();
                            return;
                        }
                    }
                }
            }
        }
    }

    ItemMeta mb = customItems.memoryBottle.getItemMeta();
    {
        mb.setDisplayName(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Bottle of Memories");
        mb.setLore(Arrays.asList(ChatColor.DARK_BLUE + "I wonder whats inside this"));
        memoryBottle.setItemMeta(mb);
    }
 /*   @EventHandler
        public void onChatSave(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        String msg = event.getMessage();

        getConfig().set(p.getName() + ".Chat" , msg);
        this.saveConfig();
    }*/
    }
