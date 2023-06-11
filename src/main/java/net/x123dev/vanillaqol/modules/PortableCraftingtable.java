package net.x123dev.vanillaqol.modules;

import com.google.common.cache.AbstractCache;
import net.x123dev.vanillaqol.VanillaQOL;
import net.x123dev.vanillaqol.util.SkullCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class PortableCraftingtable implements Listener {




    public static void init(){
        VanillaQOL.INSTANCE.getServer().getPluginManager().registerEvents(new PortableCraftingtable(), VanillaQOL.INSTANCE);

        ItemStack portableCraftingTableItemstack= SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmNkYzBmZWI3MDAxZTJjMTBmZDUwNjZlNTAxYjg3ZTNkNjQ3OTMwOTJiODVhNTBjODU2ZDk2MmY4YmU5MmM3OCJ9fX0=");
        ItemMeta portableCraftingTableMeta = portableCraftingTableItemstack.getItemMeta();
        portableCraftingTableMeta.setDisplayName(""+ ChatColor.WHITE+"Portable Crafting Table");
        portableCraftingTableMeta.setCustomModelData(116);
        portableCraftingTableItemstack.setItemMeta(portableCraftingTableMeta);

        ShapedRecipe portableCraftingTable = new ShapedRecipe(new NamespacedKey(VanillaQOL.INSTANCE, "portableCraftingTable"),portableCraftingTableItemstack);
        portableCraftingTable.shape("c","b");
        portableCraftingTable.setIngredient('c', Material.ENDER_EYE);
        portableCraftingTable.setIngredient('b', Material.CRAFTING_TABLE);
        VanillaQOL.INSTANCE.getServer().addRecipe(portableCraftingTable);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(!VanillaQOL.isID(event.getPlayer().getInventory().getItemInMainHand(),116))
            return;
        if(event.getHand()== EquipmentSlot.HAND&&(event.getAction()== Action.RIGHT_CLICK_AIR||event.getAction()==Action.RIGHT_CLICK_BLOCK)){
            event.setCancelled(true);
            event.getPlayer().openWorkbench(null,true);
        }
    }


}
