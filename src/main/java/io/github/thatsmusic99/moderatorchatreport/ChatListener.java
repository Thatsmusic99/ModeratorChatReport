package io.github.thatsmusic99.moderatorchatreport;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;
import java.util.Set;

public class ChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Set<Player> removingPlayers = new HashSet<>();
        // Broadcast the message
        for (Player player : event.getRecipients()) {
            // If the player doesn't have the MCR permissions, begone
            if (player.hasPermission("modchatreport.report")) continue;
            removingPlayers.add(player);
            player.sendMessage(String.format(event.getFormat(), event.getPlayer().getDisplayName(), event.getMessage()));
        }
        event.getRecipients().removeAll(removingPlayers);
    }
}
