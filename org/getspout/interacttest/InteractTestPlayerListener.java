package org.getspout.interacttest;

import org.bukkit.Chunk;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.CraftChunk;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class InteractTestPlayerListener extends PlayerListener {

	private final InteractTest p;

	public InteractTestPlayerListener(InteractTest p) {
		this.p = p;
	}

	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		
		if (p.enabled.contains(player.getName())) {
			p.log2(player, "Cancelled: " + event.isCancelled());
			p.log2(player, "Player name: " + player.getName());
			Block block = event.getClickedBlock();
			p.log2(player, "Block: " + block);
			String blockClass = (block == null)?null:block.getClass().getName();
			p.log2(player, "Block class: " + blockClass);
			if (block != null) {
				Chunk chunk = block.getChunk();
				p.log2(player, "Chunk: " + chunk);
				String chunkClass = (chunk == null)?null:chunk.getClass().getName();
				p.log2(player, "Chunk class: " + chunkClass);
				Chunk minecraftChunk = ((CraftChunk)chunk).getHandle().bukkitChunk;
				p.log2(player, "Chunk Loopback: " + minecraftChunk);
				p.log2(player, "Loopback correct: " + (minecraftChunk == chunk));
			}
			
		}
		
	}

}
