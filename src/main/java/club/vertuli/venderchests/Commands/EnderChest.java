package club.vertuli.venderchests.Commands;

import club.vertuli.venderchests.GUI.EnderChestGUI;
import club.vertuli.venderchests.vEnderChests;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {

    EnderChestGUI enderChestGUI = vEnderChests.getInstance().getEnderChestGUI();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            enderChestGUI.openEnderChestGUI(p);
            return true;
        }
        return false;
    }
}
