package club.vertuli.venderchests;

import club.vertuli.venderchests.Configs.ConfigCreator;
import club.vertuli.venderchests.Configs.DataManager;
import club.vertuli.venderchests.GUI.EnderChestGUI;
import club.vertuli.venderchests.Listeners.InventoryCloseListener;
import club.vertuli.venderchests.Listeners.InventoryOpenListener;
import club.vertuli.venderchests.Listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class vEnderChests extends JavaPlugin {

    private static vEnderChests instance;
    private ConfigCreator dataManager;
    private EnderChestGUI enderChestGUI = new EnderChestGUI();

    public static vEnderChests getInstance() {
        return instance;
    }

    public EnderChestGUI getEnderChestGUI() {
        return enderChestGUI;
    }


    @Override
    public void onEnable() {
        getLogger().info("HI");
        instance = this;
        registerListeners();
        loadConfig();
//        registerGUI();
    }

    @Override
    public void onDisable() {
        getLogger().info("BYE");
        saveConfig();
    }

    public void loadConfig() {
        dataManager = new ConfigCreator(this, "dataManager.yml");
        DataManager data = new DataManager();

        data.loadData(dataManager.getConfig());
        dataManager.save();
    }

    public void saveConfig() {
        dataManager = new ConfigCreator(this, "dataManager.yml");
        DataManager data = new DataManager();

        for(String key : dataManager.getConfig().getKeys(false)){
            dataManager.getConfig().set(key,null);
        }

        data.saveConfig(dataManager.getConfig());
        dataManager.save();
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new InventoryOpenListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryCloseListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

//    public void registerGUI() {
//        enderChestGUI = new EnderChestGUI();
//    }
}
