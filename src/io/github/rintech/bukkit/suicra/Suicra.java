package io.github.rintech.bukkit.suicra;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.iCo6.Constants.Nodes;
import com.iCo6.system.Account;
import com.iCo6.util.Common;

public class Suicra extends JavaPlugin implements Listener {

	@Override
	public void onLoad() {
		getLogger().info(Language_ja.onLoad);
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
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
			player.sendMessage(Language.PREFIX + Language_ja.Include_Suicra_isOP);
		} else {
			player.sendMessage(Language.PREFIX + Language_ja.Include_suicra);
		}
	}

	/**
	 * ICカードにチャージします
	 * @param player プレイヤー
	 * @param charge チャージ金額
	 */
	public void charge(Player player, int charge) {
		//TODO チャージ残高を記録

		Account account = new Account(player.getName());
		account.getHoldings().subtract(charge);

		player.sendMessage(Language.PREFIX + Language_ja.charge.replaceAll(Language.KEY_CHARGE, "" + charge +
				(String)Nodes.Major.getStringList().get(Common.plural(Double.valueOf(charge)))));
	}
}
