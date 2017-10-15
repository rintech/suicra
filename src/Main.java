import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onLoad() {
		getLogger().info(Language_ja.onLoad);
	}

	@Override
	public void onEnable() {
		getLogger().info(Language_ja.onEnable);
	}

	@Override
	public void onDisable() {
		getLogger().info(Language_ja.onDisable);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (player.isOp()) {
			player.sendMessage(Language_ja.Include_Suicra_isOP);
		} else {
			player.sendMessage(Language_ja.Include_suicra);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args, Language_ja lang) {
		if(cmd.getName().equalsIgnoreCase("sc")) {
			if(args.length == 0) {
				sender.sendMessage(lang.param_is_not_enough);
			} else if (args[0].equalsIgnoreCase("history")) {
				sender.sendMessage(lang.History_Header);
			}
			return true;
		}
		return false;
	}

}
