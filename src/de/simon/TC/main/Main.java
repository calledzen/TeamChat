package de.simon.TC.main;

import de.simon.TC.cmd.TeamChat;
import de.simon.TC.listener.TCJoin;
import de.simon.TC.listener.TCLeave;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin implements Listener {

	public static String prefix;

	@SuppressWarnings("deprecation")
	public void onEnable() {
		prefix = "§cReport §7┃ ";
		getProxy().getConsole().sendMessage(prefix + "§aErfolgreich geladen");
		getProxy().getPluginManager().registerCommand(this, (Command) new TeamChat());
		getProxy().getPluginManager().registerListener(this, (Listener) new TCJoin());
		getProxy().getPluginManager().registerListener(this, (Listener) new TCLeave());

	}

	public void onDisable() {

	}

}
