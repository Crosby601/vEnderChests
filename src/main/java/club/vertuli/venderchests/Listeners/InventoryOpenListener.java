package club.vertuli.venderchests.Listeners;

import club.vertuli.venderchests.vEnderChests;
import org.bukkit.block.EnderChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class InventoryOpenListener implements Listener {

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        if (e.getInventory().getHolder() instanceof EnderChest) {
            Player p = (Player) e.getPlayer();
            vEnderChests.getEnderChestGUI().openEnderChestGUI(p);
        }
    }
}
