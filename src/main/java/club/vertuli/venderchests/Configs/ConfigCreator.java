package club.vertuli.venderchests.Configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigCreator {

    private File configFile;
    private FileConfiguration fileConfiguration;

    // Konstruktor
    public ConfigCreator(JavaPlugin plugin, String fileName) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        configFile = new File(plugin.getDataFolder(), fileName);
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }

    public FileConfiguration getConfig() {
        return this.fileConfiguration;
    }

    public void save() {
        try {
            this.fileConfiguration.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
