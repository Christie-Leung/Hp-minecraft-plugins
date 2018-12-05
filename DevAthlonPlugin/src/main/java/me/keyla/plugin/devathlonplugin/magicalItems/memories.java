package me.keyla.plugin.devathlonplugin.magicalItems;

import me.keyla.plugin.devathlonplugin.DevAthlonPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;

import static me.keyla.plugin.devathlonplugin.magicalItems.customItems.memoryBottle;

public class memories implements Listener {
    Plugin plugin = DevAthlonPlugin.getPlugin(DevAthlonPlugin.class);
    private ItemStack item = new ItemStack(Material.SPLASH_POTION,1);


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Block clickedBlock = e.getClickedBlock();

        ItemMeta pensieves = item.getItemMeta();
        pensieves.setDisplayName(ChatColor.AQUA + "Pensieve");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "Use this with the Bottle of Memories in a cauldron");
        pensieves.setLore(lore);
        item.setItemMeta(pensieves);
        ShapedRecipe pensieveR = new ShapedRecipe(item);
        pensieveR.shape(" $ ", "$%$", " $ ");
        pensieveR.setIngredient('$', Material.COBBLESTONE);
        pensieveR.setIngredient('%', Material.FEATHER);
        plugin.getServer().addRecipe(pensieveR);

        if (clickedBlock != null) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (e.getHand().equals(EquipmentSlot.HAND)) {
                    Player p = e.getPlayer();
                    Material type = clickedBlock.getType();
                    // Interacting with a Cauldron
                    if (type == Material.CAULDRON) {
                        Material materialInHand = e.getMaterial();

                        if (materialInHand == null || materialInHand == Material.BUCKET) {
                            p.sendMessage("Not Working");

                        } else if (p.getInventory().getItemInHand().isSimilar(memoryBottle)) {
                            if (p.getInventory().contains(item)) {
                                p.sendMessage("Working, you got memory");
                                ItemStack hand = p.getInventory().getItemInHand();
                                hand.setAmount(hand.getAmount() - 1);
                                p.getInventory().remove(item);
                            } else if (!p.getInventory().contains(item)) {
                                p.sendMessage(ChatColor.DARK_RED + "Make sure you have the pensieve!");
                            }

                        } else if (!p.getInventory().contains(memoryBottle)) {
                            p.sendMessage(ChatColor.DARK_RED + "Make sure you have the bottle of memories in your hand!");
                        }
                    }
                }
            }
        }
    }
    ItemMeta mb = customItems.memoryBottle.getItemMeta();
    {
        mb.setDisplayName(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Bottle of Memories");
        mb.setLore(Arrays.asList(ChatColor.BLUE + "I wonder whats inside this"));
        memoryBottle.setItemMeta(mb);
    }

    @EventHandler
    public void playerMemories() {

        //Supposed to store what person said in chat 1 min before player has right clicked them
        //then when right clicked against cauldron, it'll show all the messages the person has said at whatever time and date

    }

}


