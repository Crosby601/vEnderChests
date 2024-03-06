package club.vertuli.venderchests.Configs;

import club.vertuli.venderchests.GUI.EnderChestGUI;
import club.vertuli.venderchests.vEnderChests;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;

public class DataManager {

    public DataManager() {}

    EnderChestGUI enderChestGUI = vEnderChests.getInstance().getEnderChestGUI();

    public void saveConfig(FileConfiguration cfg) {
        for(Map.Entry<Player, ItemStack[]> entry : enderChestGUI.getEnderChestInv().entrySet()) {
            String path = "players." + entry.getKey().getUniqueId().toString() + ".items";
            cfg.set(path, null); // Clear current configuration path to avoid duplicating items.
            int index = 0;
            for(ItemStack item : entry.getValue()) {
                // Here we are saving each item in player's EnderChest inventory separately
                if (item != null) {
                    cfg.set(path + "." + index, item.serialize());
                    index++;
                }
            }
        }
    }

    public void loadData(FileConfiguration cfg) {
        ConfigurationSection playersSection = cfg.getConfigurationSection("players");
        if (playersSection == null) return;

        for (String playerUUID : playersSection.getKeys(false)) {
            Player player = vEnderChests.getInstance().getServer().getOfflinePlayer(UUID.fromString(playerUUID)).getPlayer();
            if (player == null) continue; // Skip if player not found

            ConfigurationSection itemsSection = playersSection.getConfigurationSection(playerUUID + ".items");
            if (itemsSection == null) continue;

            ItemStack[] items = new ItemStack[itemsSection.getKeys(false).size()];
            int index = 0;
            for (String itemKey : itemsSection.getKeys(false)) {
                items[index] = ItemStack.deserialize(itemsSection.getConfigurationSection(itemKey).getValues(false));
                index++;
            }
            enderChestGUI.getEnderChestInv().put(player, items);
        }
    }
}
