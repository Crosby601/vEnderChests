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
        int slots = 0;
        if (p.hasPermission("vEnderChest.swagger")) {
            slots = 9*swaggerRows;
            inv = Bukkit.createInventory(null, slots, inventoryName);
        } else if (p.hasPermission("vEnderChest.sponsor")) {
            slots = 9*sponsorRows;
            inv = Bukkit.createInventory(null, slots, inventoryName);
        } else if (p.hasPermission("vEnderChest.svip")) {
            slots = 9*svipRows;
            inv = Bukkit.createInventory(null, slots, inventoryName);
        } else if (p.hasPermission("vEnderChest.vip")) {
            slots = 9*vipRows;
            inv = Bukkit.createInventory(null, slots, inventoryName);
        } else {
            vEnderChests.getInstance().getLogger().info(Color.colorize("&9vEnderChest &7- &cBłąd otwierania enderchest'a!"));
        }
        initItems(p, slots);
        p.openInventory(inv);
    }

    private void initItems(Player p, int slots) {
        if (!enderchestInv.containsKey(p)) return;
        int a = 0;
        for(ItemStack i : enderchestInv.get(p)) {
            inv.setItem(a, i);
            if (slots == a) return;
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
