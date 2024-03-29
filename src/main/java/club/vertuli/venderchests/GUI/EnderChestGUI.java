package club.vertuli.venderchests.GUI;

import club.vertuli.venderchests.Utils.Color;
import club.vertuli.venderchests.vEnderChests;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class EnderChestGUI {

    HashMap<Player, ItemStack[]> enderchestInv = new HashMap<>();
    private Inventory inv;
    private String inventoryName;
    private int vipRows;
    private int svipRows;
    private int sponsorRows;
    private int swaggerRows;

    public EnderChestGUI() {
        loadConfig();
    }

    public void loadConfig() {
        FileConfiguration cfg = vEnderChests.getInstance().getConfig();
        this.vipRows = cfg.getInt("Ranks.vip.rows");
        this.svipRows = cfg.getInt("Ranks.svip.rows");
        this.sponsorRows = cfg.getInt("Ranks.sponsor.rows");
        this.swaggerRows = cfg.getInt("Ranks.swagger.rows");

        this.inventoryName = Color.colorize(cfg.getString("enderChestTitle"));
    }

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
            if (slots == a) return;
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

    public int getVipRows() {
        return vipRows;
    }

    public int getSvipRows() {
        return svipRows;
    }

    public int getSponsorRows() {
        return sponsorRows;
    }

    public int getSwaggerRows() {
        return swaggerRows;
    }
}
