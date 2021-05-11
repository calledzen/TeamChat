package de.simon.TC.listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class TCLeave implements Listener {
	@EventHandler
	public void onDisconnect(PlayerDisconnectEvent e) {
		ProxiedPlayer p = e.getPlayer();
		if (p.hasPermission("tc.send")) {

			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				if (all.hasPermission("tc.send")) {

					all.sendMessage("§8[§cTeam§8] §7" + p.getName() + " §7ist nun §coffline");

				}
			}

		}
	}
}
