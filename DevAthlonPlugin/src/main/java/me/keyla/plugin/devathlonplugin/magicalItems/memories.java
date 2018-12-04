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
    private int amount = 1;
    private ItemStack item = new ItemStack(Material.WATER_BUCKET,1);

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Block clickedBlock = e.getClickedBlock();

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

        if (clickedBlock != null) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (e.getHand().equals(EquipmentSlot.HAND)) {
                    Player p = e.getPlayer();
                    Material type = clickedBlock.getType();
                    // Interacting with a Cauldron
                    if (type == Material.CAULDRON) {
                        Material materialInHand = e.getMaterial();
                        ItemStack i = e.getItem();
                        p.sendMessage("Detected cauldron right click");

                        if (materialInHand == null || materialInHand == Material.BUCKET) {
                            p.sendMessage("Not Working");

                        } else if (p.getInventory().getItemInMainHand().isSimilar(memoryBottle) && p.getInventory().getItemInMainHand().isSimilar(item)) {
                            p.sendMessage("Working, you got memory");
                            p.getInventory().remove(memoryBottle);
                            p.getInventory().remove(item);

                        } else if (!p.getInventory().getItem(amount).isSimilar(memoryBottle) && p.getInventory().getItemInMainHand().isSimilar(item)) {
                            p.sendMessage(ChatColor.RED + "You don't have the memory bottle or pensieve");
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

    @EventHandler
    public void playerMemories() {


    }

}


