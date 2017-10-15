import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@EventHandler
	public void onLoad() {
		getLogger().info("Suicraプラグインをロード中です・・・");
	}

	@EventHandler
	public void onEnable() {
		getLogger().info("Suicraプラグインが有効になりました！");
	}

	@EventHandler
	public void onDisable() {
		getLogger().info("Suicraプラグインが無効になりました！");
	}
}
