package org.getspout.interacttest;

import java.util.HashSet;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;

public class InteractTest extends JavaPlugin {

	InteractTestPlayerListener playerListener = new InteractTestPlayerListener(this);
	
	@Override
	public void onDisable() {
	}
	
	HashSet<String> enabled = new HashSet<String>();

	@Override
	public void onEnable() {
		
		getCommand("itest").setExecutor(new InteractCommand(this));
		
		getServer().getPluginManager().registerEvent(Type.PLAYER_INTERACT, playerListener, Priority.Monitor, this);
		getServer().getLogger().info("[InteractTest] Interaction test enabled");
		
	}
	
	public void log2(Player player, String message) {
		getServer().getLogger().info(message);
		player.sendMessage(message);
	}

}
