package club.vertuli.venderchests.Listeners;

import club.vertuli.venderchests.vEnderChests;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryOpenListener implements Listener {

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        if (e.getInventory().getType() == InventoryType.ENDER_CHEST) {
            e.setCancelled(true);
            Player p = (Player) e.getPlayer();
            vEnderChests.getEnderChestGUI().openEnderChestGUI(p);
        }
    }
}
