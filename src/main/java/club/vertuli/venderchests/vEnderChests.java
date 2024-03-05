package club.vertuli.venderchests;

import org.bukkit.plugin.java.JavaPlugin;

public final class vEnderChests extends JavaPlugin {

    private static vEnderChests instance;

    public static vEnderChests getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("HI");
        instance = this;
    }

    @Override
    public void onDisable() {
        getLogger().info("BYE");
    }
}
