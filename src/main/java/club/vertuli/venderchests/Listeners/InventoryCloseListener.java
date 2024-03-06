package club.vertuli.venderchests.Listeners;

import club.vertuli.venderchests.GUI.EnderChestGUI;
import club.vertuli.venderchests.Utils.Color;
import club.vertuli.venderchests.vEnderChests;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class InventoryCloseListener implements Listener {

    EnderChestGUI enderChestGUI = vEnderChests.getInstance().getEnderChestGUI();
    private final int vipRows = 3;
    private final int svipRows = 4;
    private final int sponsorRows = 5;
    private final int swaggerRows = 6;
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (e.getInventory().getTitle().equalsIgnoreCase(enderChestGUI.getInventoryName())) {
            HumanEntity p = (Player)e.getPlayer();
            p.sendMessage("zapisywanie");
            if (p.hasPermission("vEnderChest.vip")) {
                enderChestGUI.getEnderChestInv().put((Player) p,getLoopItems((Player) p, 9*vipRows, e.getInventory()));
            } else if (p.hasPermission("vEnderChest.svip")) {
                enderChestGUI.getEnderChestInv().put((Player) p,getLoopItems((Player) p, 9*svipRows, e.getInventory()));
            } else if (p.hasPermission("vEnderChest.sponsor")) {
                enderChestGUI.getEnderChestInv().put((Player) p,getLoopItems((Player) p, 9*sponsorRows, e.getInventory()));
            } else if (p.hasPermission("vEnderChest.swagger")) {
                enderChestGUI.getEnderChestInv().put((Player) p,getLoopItems((Player) p, 9*swaggerRows, e.getInventory()));
            } else {
                vEnderChests.getInstance().getLogger().info(Color.colorize("&9vEnderChest &7- &cBłąd zapisywania enderchest'a!"));
            }
            p.sendMessage("" + Arrays.toString(enderChestGUI.getEnderChestInv().get(p)));
        }
    }

    private ItemStack[] getLoopItems(Player p, int slots, Inventory inv) {
        ItemStack[] is = new ItemStack[slots];
        for (int i=0; i < slots; i++) {
            if (inv.getItem(i).getType() == null) {
                ItemStack air = new ItemStack(Material.AIR);
                is[i] = air;
            } else {
                is[i] = inv.getItem(i);
            }
        }
        return is;
    }
}
