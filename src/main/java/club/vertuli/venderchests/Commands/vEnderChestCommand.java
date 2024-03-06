package club.vertuli.venderchests.Commands;

import club.vertuli.venderchests.GUI.EnderChestGUI;
import club.vertuli.venderchests.Utils.Color;
import club.vertuli.venderchests.vEnderChests;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class vEnderChestCommand implements CommandExecutor {

    EnderChestGUI enderChestGUI = vEnderChests.getInstance().getEnderChestGUI();
    vEnderChests instance = vEnderChests.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if ((args.length == 0 || args[0].equalsIgnoreCase("help")) && p.hasPermission("vEnderChest.command.help")) {
                p.sendMessage("");
                p.sendMessage(Color.colorize("&0 &8▪ &7/venderchest &ehelp &8- &7Lista komend"));
                p.sendMessage(Color.colorize("&0 &8▪ &7/venderchest &ereload &8- &7Przeładowanie konfiguracji"));
                p.sendMessage("");
            } else if (args[0].equalsIgnoreCase("reload") && p.hasPermission("vEnderChests.command.reload")) {
                instance.reloadConfig();
                instance.saveDefaultConfig();
                enderChestGUI.loadConfig();
                p.sendMessage(Color.colorize("&9vEnderChests &8▪ &7Przeładowano pomyślnie konfiguracje!"));
            }
        }
        return false;
    }
}
