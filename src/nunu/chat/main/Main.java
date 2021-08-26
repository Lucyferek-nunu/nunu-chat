package nunu.chat.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements CommandExecutor {
	
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Nunu chat");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("chat")) {
			if(p.hasPermission("nunu.chat") || p.isOp()) {
				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("clear")) {
						for(int i = 0; i < 101; i++) {
							for(Player players : Bukkit.getOnlinePlayers()) {
							    players.sendMessage(" ");
							}
						}
						for(Player players : Bukkit.getOnlinePlayers()) {
							players.sendMessage("");
							players.sendMessage(ChatColor.YELLOW + "Chat got clear by " + p.getName());
							players.sendMessage("");
						}
					}
				} else {
					p.sendMessage(ChatColor.GRAY + "Use: " + ChatColor.YELLOW + "/chat [clear]");
				}
			} else {
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.7F, 0.7F);
				p.sendMessage(ChatColor.RED + "No permission.");
			}
		}
		return false;
	}
}
