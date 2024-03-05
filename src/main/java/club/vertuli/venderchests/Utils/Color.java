package club.vertuli.venderchests.Utils;

import org.bukkit.ChatColor;

public class Color {

    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
