package bilzox.acemix.studios;

import bilzox.acemix.studios.license.LicenseManager;
import bilzox.acemix.studios.api.IPCheckAPI;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for the IPSecurity plugin.
 * Handles license validation and server protection on startup.
 *
 * Created by Acemix
 * Project: IPSecurity
 * Date: 17/6/2025 @ 13:45
 */
public final class IPSecurity extends JavaPlugin {

    /**
     * Called when the plugin is enabled. Validates license key and initializes protection.
     */
    @Override
    public void onEnable() {
        String userKey = getConfig().getString("license-key");

        if (!LicenseManager.isKeyValid(userKey)) {
            getLogger().warning("Invalid license. Deactivating plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // 🔐 Apply IP protection through the public API
        IPCheckAPI.initialize(this);

        // TODO: Continue plugin initialization here
    }

    /**
     * Called when the plugin is disabled.
     */
    @Override
    public void onDisable() {
        // Optional cleanup logic
    }
}
