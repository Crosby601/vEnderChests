package club.vertuli.venderchests.Listeners;

import club.vertuli.venderchests.Configs.ConfigCreator;
import club.vertuli.venderchests.Configs.DataManager;
import club.vertuli.venderchests.GUI.EnderChestGUI;
import club.vertuli.venderchests.vEnderChests;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class PlayerJoinListener implements Listener {

    EnderChestGUI enderChestGUI = vEnderChests.getInstance().getEnderChestGUI();
    private ConfigCreator dataManager;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (!enderChestGUI.getEnderChestInv().containsKey(e.getPlayer())) {
            dataManager = new ConfigCreator(vEnderChests.getInstance(), "dataManager.yml");
            loadData(dataManager.getConfig(), e.getPlayer());

        }
    }

    public void loadData(FileConfiguration cfg, Player player) {
        ConfigurationSection playersSection = cfg.getConfigurationSection("players");
        if (playersSection == null) return;

        ConfigurationSection itemsSection = playersSection.getConfigurationSection(player.getUniqueId().toString() + ".items");

        ItemStack[] items = new ItemStack[itemsSection.getKeys(false).size()];
        int index = 0;
        for (String itemKey : itemsSection.getKeys(false)) {
            items[index] = ItemStack.deserialize(itemsSection.getConfigurationSection(itemKey).getValues(false));
            index++;
        }
        enderChestGUI.getEnderChestInv().put(player, items);
    }
}
