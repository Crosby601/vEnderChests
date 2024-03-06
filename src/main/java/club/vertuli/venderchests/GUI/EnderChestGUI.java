package club.vertuli.venderchests.GUI;

import club.vertuli.venderchests.Utils.Color;
import club.vertuli.venderchests.vEnderChests;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class EnderChestGUI {

    HashMap<Player, ItemStack[]> enderchestInv = new HashMap<>();
    private Inventory inv;
    private final String inventoryName = Color.colorize("&9Twoj EnderChest");
    private final int vipRows = 3;
    private final int svipRows = 4;
    private final int sponsorRows = 5;
    private final int swaggerRows = 6;

    public void openEnderChestGUI(Player p) {
        if (p.hasPermission("vEnderChest.swagger")) {
            inv = Bukkit.createInventory(null, 9*swaggerRows, inventoryName);
        } else if (p.hasPermission("vEnderChest.sponsor")) {
            inv = Bukkit.createInventory(null, 9*sponsorRows, inventoryName);
        } else if (p.hasPermission("vEnderChest.svip")) {
            inv = Bukkit.createInventory(null, 9*svipRows, inventoryName);
        } else if (p.hasPermission("vEnderChest.vip")) {
            inv = Bukkit.createInventory(null, 9*vipRows, inventoryName);
        } else {
            vEnderChests.getInstance().getLogger().info(Color.colorize("&9vEnderChest &7- &cBłąd otwierania enderchest'a!"));
        }
        initItems(p);
        p.openInventory(inv);
    }

    private void initItems(Player p) {
        if (!enderchestInv.containsKey(p)) return;
        int a = 0;
        for(ItemStack i : enderchestInv.get(p)) {
            inv.setItem(a, i);
            a++;
        }
    }

    public HashMap<Player, ItemStack[]> getEnderChestInv() {
        return enderchestInv;
    }

    public String getInventoryName() {
        return inventoryName;
    }


}
