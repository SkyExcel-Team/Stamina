package git.stamina.me.runnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StaminaBar extends BukkitRunnable {

    private Player player;
    private String test = ChatColor.GREEN + "■■■■■■■■■■■■■■■■■";

    public StaminaBar(Player player) {
        this.player = player;
    }


    @Override
    public void run() {


        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(test));
    }
}
