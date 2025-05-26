package it.fulminazzo.fulmicommands;

import it.fulminazzo.fulmicommands.configuration.ConfigurationException;
import it.fulminazzo.fulmicommands.configuration.Configurator;
import it.fulminazzo.yamlparser.configuration.FileConfiguration;
import org.jetbrains.annotations.NotNull;

/**
 * An implementation of {@link FulmiPlugin} that supports messages file.
 */
public interface FulmiMessagesPlugin extends FulmiPlugin {

    /**
     * Gets the messages configuration.
     *
     * @return the configuration
     */
    @NotNull FileConfiguration getMessages();

    /**
     * Sets up the <b>messages.yml</b> configuration file.
     *
     * @return the messages configuration
     * @throws ConfigurationException in case of any errors
     */
    default @NotNull FileConfiguration setupMessages() throws ConfigurationException {
        return Configurator.newBuilder()
                .pluginDirectory(getPluginDirectory())
                .name("messages")
                .build();
    }

}
