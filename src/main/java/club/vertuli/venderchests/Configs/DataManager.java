package club.vertuli.venderchests.Configs;

import club.vertuli.venderchests.GUI.EnderChestGUI;
import club.vertuli.venderchests.vEnderChests;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class DataManager {

    public DataManager() {}

    EnderChestGUI enderChestGUI = vEnderChests.getInstance().getEnderChestGUI();

    public void saveConfig(FileConfiguration cfg) {
        Set<Player> keys = enderChestGUI.getEnderChestInv().keySet();
        int id = 0;
        for(Player p : keys) {
            cfg.set(id + "player", p);
            for(ItemStack i :enderChestGUI.getEnderChestInv().get(p)) {
                cfg.set(id + "items", i);
            }
            id++;
        }
    }

    public void loadData(FileConfiguration cfg) {
        ConfigurationSection section = cfg.getConfigurationSection("");
        EnderChestGUI enderChestGUI = vEnderChests.getInstance().getEnderChestGUI();
        if (section == null) return;
        Set<String> keys = section.getKeys(false);
        int ids = keys.size();
        Player p = null;
        ItemStack[] items = new ItemStack[0];
        for (int i = 0; i < ids; i++) {
            p = (Player) cfg.getOfflinePlayer(i + "player");
            items = cfg.getList(i + "items").toArray(new ItemStack[0]);
        }
        enderChestGUI.getEnderChestInv().put(p, items);
    }
}