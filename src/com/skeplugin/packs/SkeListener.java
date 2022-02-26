package com.skeplugin.packs;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.clip.placeholderapi.PlaceholderAPI;
public class SkeListener implements Listener {
	public final Main pl = Main.getPlugin();
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		if (pl.getConfig().getBoolean("enabled")) {
//			pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(e.getPlayer(), pl.getConfig().getString("global-mess-player-left"))));
			e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(e.getPlayer(), pl.getConfig().getString("global-mess-player-left"))));
		}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (pl.getConfig().getBoolean("enabled")) {
			Player p = e.getPlayer();
			if (p.hasPlayedBefore()) {
				pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(e.getPlayer(), pl.getConfig().getString("player-mess-joined"))));
				e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(e.getPlayer(), pl.getConfig().getString("player-mess-joined"))));
			} else {
				pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(e.getPlayer(), pl.getConfig().getString("player-mess-first-joined"))));
				e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(e.getPlayer(), pl.getConfig().getString("player-mess-first-joined"))));
			}
		}
	}
}