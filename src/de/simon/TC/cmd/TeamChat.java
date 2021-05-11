package de.simon.TC.cmd;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TeamChat extends Command {
	public TeamChat() {
		super("tc");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender commandSender, String[] args) {
		if (commandSender instanceof ProxiedPlayer) {
			ProxiedPlayer pp = (ProxiedPlayer) commandSender;
			if (pp.hasPermission("tc.send")) {
				if (args.length > 0) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("tc.send")) {
							String msg = "";
							for (int i = 0; i < args.length; i++)
								msg = msg + args[i] + " ";
							String message = pp.getName();
							all.sendMessage("§8[§cTC§8] §c" + message + "§8: §7" + msg);

						}
					}

				} else {

					pp.sendMessage("§8[§cTC§8] §7Du musst eine Nachricht angeben");
				}

			} else {

				pp.sendMessage("§8[§cTC§8] §7Keine Rechte!");
			}

		}

	}

}
