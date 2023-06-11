package net.x123dev.vanillaqol.modules;

import net.x123dev.vanillaqol.VanillaQOL;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class NoCropTrampling implements Listener {

    public static void init(){
        VanillaQOL.INSTANCE.getServer().getPluginManager().registerEvents(new NoCropTrampling(), VanillaQOL.INSTANCE);
    }

    @EventHandler
    public void onPlayerTrampleCrop(PlayerInteractEvent event){
        if(event.getAction()== Action.PHYSICAL&& Objects.requireNonNull(event.getClickedBlock()).getType()== Material.FARMLAND)
            event.setCancelled(true);
    }



}