package club.vertuli.venderchests.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        if (label.equalsIgnoreCase("enderchest")) {
            sender.sendMessage("enderchest open");
            return true;
        }
        return false;
    }
}
