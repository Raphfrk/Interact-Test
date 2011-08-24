package org.getspout.interacttest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InteractCommand implements CommandExecutor {
	
	private final InteractTest p;
	
	InteractCommand(InteractTest p) {
		this.p = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandString, String[] args) {

		if (sender.isOp() && sender instanceof Player) {
			if (p.enabled.add(((Player)sender).getName())) {
				sender.sendMessage("[InteractTest] You are added to the interact test list");
			} else {
				p.enabled.remove(((Player)sender).getName());
				sender.sendMessage("[InteractTest] You are removed from the interact test list");
			}
			return true;
		}
		return false;
		
	}

}
