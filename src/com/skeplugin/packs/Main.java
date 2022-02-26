package com.skeplugin.packs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Main plugin;
	public static Main getPlugin() {
		return plugin;
	}
	@Override
	public void onEnable() {
		plugin = this;
		if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
			registerCommands();
			registerConfig();
			Bukkit.getPluginManager().registerEvents(new SkeListener(), this);
		    getServer().getConsoleSender().sendMessage("["+ ChatColor.RED + "LJMess" + ChatColor.RESET + "] Plugin is loaded");
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
	}
	@Override
	public void onDisable() {
		System.out.print("["+ ChatColor.RED + "LJMess" + ChatColor.RESET + "] Plugin is unloaded");
	}
	public void registerCommands() {
		getCommand("ljmess").setExecutor(new Commands());
	}
	public void registerConfig() {
		saveDefaultConfig();
	  }
}