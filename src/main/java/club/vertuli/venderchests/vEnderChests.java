package club.vertuli.venderchests;

import club.vertuli.venderchests.GUI.EnderChestGUI;
import club.vertuli.venderchests.Listeners.InventoryOpenListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class vEnderChests extends JavaPlugin {

    private static vEnderChests instance;
    private static EnderChestGUI enderChestGUI;

    public static vEnderChests getInstance() {
        return instance;
    }

    public static EnderChestGUI getEnderChestGUI() {
        return enderChestGUI;
    }

    @Override
    public void onEnable() {
        getLogger().info("HI");
        instance = this;
        registerListeners();
        registerGUI();
    }

    @Override
    public void onDisable() {
        getLogger().info("BYE");
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new InventoryOpenListener(), this);
    }

    public void registerGUI() {
        enderChestGUI = new EnderChestGUI();
    }
}
