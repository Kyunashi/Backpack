package main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import utils.Config;

public class Main extends JavaPlugin implements Listener {

	private static Main instance;
	private Config config;
	private BackpackManager bpManager;
	private ItemManager itemManager;

	@Override
	public void onLoad() {

		instance = this;
		config = new Config();

	}


	@Override
	public void onEnable() {

		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Backpack plugin started");
		PluginManager manager = Bukkit.getPluginManager();
		manager.registerEvents(new BackpackListener(), this);

		bpManager = new BackpackManager();
		itemManager = new ItemManager();

		itemManager.initialize();

	}


	@Override
	public void onDisable() {

		bpManager.save();
		config.save();

	}


	public static Main getInstance() {

		return instance;

	}


	public Config getConfiguration() {

		return config;

	}


	public BackpackManager getBpManager() {

		return bpManager;

	}

}
