package com.skeplugin.packs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	public final Main pl = Main.getPlugin();
	public String notPer(String per_name) {
		String not_per = pl.getConfig().getString("missing-perm").replace("{perm_name}", per_name);
		return not_per;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			// Enable, disable, reload command
			try {
				if (args[0].equalsIgnoreCase("enable")) {
					if (p.hasPermission("ljmess.enable")) {
						pl.getConfig().set("enabled", true);
						pl.saveConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("enabled-mess")));
					} else {
						p.sendMessage(notPer("ljmess.enable"));
					}
				} else if (args[0].equalsIgnoreCase("disable")) {
					if (p.hasPermission("ljmess.disable")) {
						pl.getConfig().set("enabled", false);
						pl.saveConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("disabled-mess")));
					} else {
						p.sendMessage(notPer("ljmess.disable"));
					}
				}
				 else if (args[0].equalsIgnoreCase("reload")) {
						if (p.hasPermission("ljmess.reload")) {
							pl.reloadConfig();
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("reloaded-mess")));
						} else {
							p.sendMessage(notPer("ljmess.reload"));
						}
					} else {
						p.sendMessage("Use: /ljmess <enable/disable/reload>");
					}
			} catch (ArrayIndexOutOfBoundsException er) {
				p.sendMessage("Use: /ljmess <enable/disable/reload>");
			}
		} else {
			try {
			if (args[0].equalsIgnoreCase("enable")) {
					pl.getConfig().set("enabled", true);
					pl.saveConfig();
					pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("enabled-mess")));
			} else if (args[0].equalsIgnoreCase("disable")) {
					pl.getConfig().set("enabled", false);
					pl.saveConfig();
					pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("disabled-mess")));
			}
			 else if (args[0].equalsIgnoreCase("reload")) {
						pl.reloadConfig();
						pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("reloaded-mess")));
				} else {
					pl.getServer().getConsoleSender().sendMessage("Use: ljmess <enable/disable/reload>");
				}
			} catch (ArrayIndexOutOfBoundsException er) {
				System.out.print("Use: ljmess <enable/disable/reload>");
			}
		}
		return true;
	}
}