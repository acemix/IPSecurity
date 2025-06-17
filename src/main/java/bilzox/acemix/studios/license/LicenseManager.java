package bilzox.acemix.studios.license;

import bilzox.acemix.studios.checker.EnvChecker;

/**
 * LicenseManager handles the validation of license keys
 * depending on the server environment (Spigot, Bungee, Velocity).
 *
 * Created by Acemix
 * Project: IPSecurity
 * Date: 17/6/2025 @ 13:50
 */
public class LicenseManager {

    private static final String SPIGOT_KEY = "exampleSpigot";
    private static final String PROXY_KEY = "exampleProxy";

    /**
     * Validates the provided license key according to the detected server environment.
     *
     * @param key The license key provided in the configuration file.
     * @return true if the key matches the expected key for the environment; false otherwise.
     */
    public static boolean isKeyValid(String key) {
        if (EnvChecker.isBukkit()) {
            return SPIGOT_KEY.equals(key);
        } else if (EnvChecker.isBungee() || EnvChecker.isVelocity()) {
            return PROXY_KEY.equals(key);
        }
        return false;
    }
}