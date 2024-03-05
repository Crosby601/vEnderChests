package club.vertuli.venderchests;

import org.bukkit.plugin.java.JavaPlugin;

public final class vEnderChests extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HI");

    }

    @Override
    public void onDisable() {
        getLogger().info("BYE");
    }
}
