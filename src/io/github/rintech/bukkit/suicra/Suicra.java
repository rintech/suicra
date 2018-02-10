package io.github.rintech.bukkit.suicra;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.iCo6.Constants.Nodes;
import com.iCo6.system.Account;
import com.iCo6.util.Common;

public class Suicra extends JavaPlugin implements Listener {

	public static File chargesFile;
	public static HashMap<UUID, Integer> charges = new HashMap<UUID, Integer>();
	private boolean save = false;

	/*@Override
	public void onLoad() {
		getLogger().info(Language_ja.onLoad);
	}*/

	@Override
	public void onEnable() {
		getDataFolder().mkdirs();
		if (chargesFile.exists()) {
			//TODO ろーど
		} else {
			try {
				(chargesFile = new File(getDataFolder(), "charges.dat")).createNewFile();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		//TODO -_-
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info(Language_ja.onEnable);
	}

	@Override
	public void onDisable() {
		save();
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

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		save();
	}

	public void saveCharges() {
		save = true;
	}

	/**
	 * ICカードにチャージします
	 * @param player プレイヤー
	 * @param charge チャージ金額
	 */
	public void charge(Player player, int charge) {
		Integer c = charges.get(player.getUniqueId());
		if (c == null)
			c = 0;
		charges.put(player.getUniqueId(), c + charge);
		saveCharges();

		Account account = new Account(player.getName());
		account.getHoldings().subtract(charge);

		player.sendMessage(Language.PREFIX + Language_ja.charge.replaceAll(Language.KEY_CHARGE, "" + charge +
				(String)Nodes.Major.getStringList().get(Common.plural(Double.valueOf(charge)))));
	}

	//データが変更されたらセーブを予約し、
	//プレイヤーがログアウトまたはプラグインが無効になるときにセーブされる。
	private void save() {
		if (save) {

		}
	}
}
