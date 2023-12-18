package com.lu7creative.lu7creative;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;

public final class lu7creative extends JavaPlugin implements Listener, CommandExecutor {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("lu7creativereload").setExecutor(this);
        getCommand("lu7creativetest").setExecutor(this);
        loadConfig(); // Load the config

        // Log successful enable
        getLogger().log(Level.INFO, "LU7 Creative plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "LU7 Creative plugin has been disabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (config.getBoolean("enablePlayerJoinNotification", true)
        && !event.getPlayer().hasPermission("lu7creative.presencebypass")) {
            sendNotification("Player Joined", event.getPlayer().getName() + " has just joined the server!", "wave,video_game,player_joined");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (config.getBoolean("enablePlayerQuitNotification", true)
        && !event.getPlayer().hasPermission("lu7creative.presencebypass") ) {
            sendNotification("Player Left", event.getPlayer().getName() + " left the server!", "wave,video_game,player_left");
        }
    }

    @EventHandler
    public void onPluginEnable(PluginEnableEvent event) {
        if (event.getPlugin().equals(this)) {
            if (config.getBoolean("enableServerStartNotification", true)) {
                // Send a notification when the plugin is enabled (server starts)
                sendNotification("Server Started", "The server has started.", "green_circle,video_game,server_started");
            }
        }
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {
        if (event.getPlugin().equals(this)) {
            if (config.getBoolean("enableServerStopNotification", true)) {
                // Send a notification when the plugin is disabled (server stops)
                sendNotification("Server Stopped", "The server has stopped.", "red_circle,video_game,server_stopped");
            }
        }
    }

    // Helper method to send notifications with specific tags
    private void sendNotification(String title, String message, String tags) {
        String notificationUrl = config.getString("notificationUrl");
        String notificationToken = config.getString("notificationToken");

        if (notificationUrl == null || notificationToken == null) {
            getLogger().warning("Notification URL or token is not configured. Please set them in config.yml.");
            return;
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(notificationUrl).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + notificationToken);
            connection.setRequestProperty("Title", title);
            connection.setRequestProperty("Tags", tags);

            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = message.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            // Handle the response code and any other processing as needed

        } catch (Exception e) {
            getLogger().log(Level.WARNING, "Failed to send notification: " + e.getMessage());
        }
    }

    // Helper method to load the config
    private void loadConfig() {
        saveDefaultConfig();
        config = getConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("lu7creativereload") || cmd.getName().equalsIgnoreCase("lu7creativetest")) {
            if (sender.hasPermission("lu7creative.commands")) {
                // Command logic here
                if (cmd.getName().equalsIgnoreCase("lu7creativereload")) {
                    reloadConfig();
                    config = getConfig();
                    sender.sendMessage("LU7 Creative configuration reloaded.");
                } else if (cmd.getName().equalsIgnoreCase("lu7creativetest")) {
                    if (args.length == 0) {
                        sender.sendMessage("Usage: /lu7creativetest <message>");
                        return true;
                    }

                    StringBuilder message = new StringBuilder();
                    for (String arg : args) {
                        message.append(arg).append(" ");
                    }

                    sendNotification("Test Notification", message.toString().trim(), "test,video_game");
                    sender.sendMessage("Test notification sent.");
                }
                return true;
            } else {
                sender.sendMessage("You don't have permission to use this command.");
                return false;
            }
        }
        return false;
    }
}
