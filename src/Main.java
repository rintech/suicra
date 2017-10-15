import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@EventHandler
	public void onLoad() {
		getLogger().info(Language_ja.onLoad);
	}

	@EventHandler
	public void onEnable() {
		getLogger().info(Language_ja.onEnable);
	}

	@EventHandler
	public void onDisable() {
		getLogger().info(Language_ja.onDisable);
	}

	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (player.isOp()) {
			player.sendMessage(Language_ja.Include_Suicra_isOP);
		} else {
			player.sendMessage(Language_ja.Include_suicra);
		}
	}

	public void setKaisatsu() {

	}

}
