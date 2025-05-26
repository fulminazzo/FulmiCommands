package it.fulminazzo.fulmicommands;

import it.fulminazzo.fulmicommands.configuration.ConfigurationException;
import it.fulminazzo.fulmicommands.configuration.ConfigurationType;
import it.fulminazzo.fulmicommands.configuration.Configurator;
import it.fulminazzo.yamlparser.configuration.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * A basic implementation of a FulmiCommands plugin.
 */
public interface FulmiPlugin {

    /**
     * Gets the configuration.
     *
     * @return the configuration
     */
    @NotNull FileConfiguration getConfiguration();

    /**
     * Sets up the <b>config.yml</b> configuration file.
     *
     * @return the configuration
     * @throws ConfigurationException in case of any errors
     */
    default @NotNull FileConfiguration setupConfiguration() throws ConfigurationException {
        return Configurator.newBuilder()
                .pluginDirectory(getPluginDirectory())
                .name("config")
                .type(getConfigurationType())
                .build();
    }

    /**
     * The type of the {@link #getConfiguration()} configuration.
     * By default, it is {@link ConfigurationType#YAML}.
     *
     * @return configuration type
     */
    default @NotNull ConfigurationType getConfigurationType() {
        return ConfigurationType.YAML;
    }

    /**
     * Gets the plugin directory.
     *
     * @return the plugin directory
     */
    @NotNull File getPluginDirectory();

}
