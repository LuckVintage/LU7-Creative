package com.lu7creative.lu7creative;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {

    private static final String VERSION_CHECK_URL = "https://plugin.lu7creative.net/version.txt";
    private String currentVersion;
    private JavaPlugin plugin;

    public UpdateChecker(JavaPlugin plugin, String currentVersion) {
        this.plugin = plugin;
        this.currentVersion = currentVersion;
    }

    public boolean checkForUpdates() {
        try {
            URL url = new URL(VERSION_CHECK_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String latestVersion = reader.readLine();

            reader.close();

            // Compare versions
            if (latestVersion != null && !latestVersion.equals(currentVersion)) {
                plugin.getLogger().info("A new version of the LU7 Creative plugin is available: " + latestVersion);
                sendUpdateNotification(latestVersion);
                return true;
            } else {
                plugin.getLogger().info("You are running the latest version of the LU7 Creative plugin!");
                return false;
            }
        } catch (IOException e) {
            String errorMessage = "Error checking for updates! If this issue persists, please create an issue on Github: " + e.getMessage();
            plugin.getLogger().warning(errorMessage);
            sendErrorNotification(errorMessage);
            return false; // Return false in case of an error
        }
    }

    private void sendUpdateNotification(String latestVersion) {
        // Call the existing method in lu7creative.java to send the notification
        plugin.getServer().getScheduler().runTask(plugin, () -> {
            ((lu7creative) plugin).sendNotification("Update Available", "A new version of LU7 Creative is available: " + latestVersion, "update,video_game");
        });
    }

    private void sendErrorNotification(String errorMessage) {
        // Call the existing method in lu7creative.java to send the error notification
        plugin.getServer().getScheduler().runTask(plugin, () -> {
            ((lu7creative) plugin).sendNotification("Update Check Error", errorMessage, "error,video_game");
        });
    }
}
