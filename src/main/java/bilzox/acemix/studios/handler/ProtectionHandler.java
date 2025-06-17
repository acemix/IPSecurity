package bilzox.acemix.studios.handler;

import bilzox.acemix.studios.manager.SecurityManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * ProtectionHandler applies the protection mechanism when the plugin is initialized.
 *
 * Created by Acemix
 * Project: IPSecurity
 * Date: 17/6/2025 @ 13:46
 */
public class ProtectionHandler {

    /**
     * Applies server protection. If the server is unauthorized, it disables the plugin.
     *
     * @param plugin The plugin instance to act upon.
     */
    public static void applyProtection(Plugin plugin) {
        if (!SecurityManager.isAuthorized()) {
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                plugin.getLogger().warning("Unauthorized server! Deactivating...");

                // OPTION 1: Deactivate plugin
                Bukkit.getPluginManager().disablePlugin(plugin);

                // OPTION 2: Delete the plugin
                // FileUtils.deletePluginFile(plugin);

                // OPTION 3: Shut down the server
                // Bukkit.shutdown();

            }, 40L);
        }
    }
}