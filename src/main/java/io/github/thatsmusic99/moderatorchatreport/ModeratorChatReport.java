package io.github.thatsmusic99.moderatorchatreport;

import org.bukkit.plugin.java.JavaPlugin;

public final class ModeratorChatReport extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
