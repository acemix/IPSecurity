package bilzox.acemix.studios.api;

import bilzox.acemix.studios.handler.ProtectionHandler;
import org.bukkit.plugin.Plugin;

/**
 * Public API to initialize the IP protection logic for a plugin.
 *
 * Created by Acemix
 * Project: IPSecurity
 * Date: 17/6/2025 @ 13:47
 */
public class IPCheckAPI {

    /**
     * Initializes the IP protection layer.
     *
     * @param plugin The plugin instance requesting initialization.
     */
    public static void initialize(Plugin plugin) {
        ProtectionHandler.applyProtection(plugin);
    }
}