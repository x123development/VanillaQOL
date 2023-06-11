package net.x123dev.vanillaqol;

import net.x123dev.vanillaqol.modules.PortableCraftingtable;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class VanillaQOL extends JavaPlugin {

    public static VanillaQOL INSTANCE;


    @Override
    public void onEnable() {
        INSTANCE=this;

        PortableCraftingtable.init();

        Bukkit.getLogger().info("enabled!");
    }

    @Override
    public void onDisable() {

        Bukkit.getLogger().info("disabled!");
    }

    public static boolean isID(ItemStack item,int ID){
        return (item!=null&&item.hasItemMeta()&&item.getItemMeta().hasCustomModelData()&&item.getItemMeta().getCustomModelData()==ID);
    }
}
