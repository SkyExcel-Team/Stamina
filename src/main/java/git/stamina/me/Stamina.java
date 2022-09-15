package git.stamina.me;

import git.stamina.me.runnable.StaminaBar;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class Stamina extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        super.onEnable();
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        StaminaBar staminaBar = new StaminaBar(player);
        staminaBar.runTaskTimer(this, 0, 20);
        ItemStack bottle = new ItemStack(Material.POTION, 64);
        ItemMeta meta = bottle.getItemMeta();
        PotionMeta pmeta = (PotionMeta) meta;
        PotionData pdata = new PotionData(PotionType.WATER);
        pmeta.setBasePotionData(pdata);
        bottle.setItemMeta(meta);

        player.getInventory().addItem(bottle);

    }
}
