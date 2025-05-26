package it.fulminazzo.fulmicommands;

import it.fulminazzo.fulmicommands.configuration.ConfigurationException;
import it.fulminazzo.fulmicommands.configuration.Configurator;
import it.fulminazzo.fulmicommands.messages.DefaultFulmiMessages;
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
        return setupMessages(new DefaultFulmiMessages[0]);
    }

    /**
     * Sets up the <b>messages.yml</b> configuration file.
     *
     * @param messages if the configuration file is being created,
     *                 it will be populated with the messages from
     *                 {@link DefaultFulmiMessages#getDefaultMessage()}
     * @return the messages configuration
     * @throws ConfigurationException in case of any errors
     */
    default @NotNull FileConfiguration setupMessages(final @NotNull DefaultFulmiMessages[] messages) throws ConfigurationException {
        return Configurator.newBuilder()
                .pluginDirectory(getPluginDirectory())
                .name("messages")
                .onCreated(f -> {
                    for (DefaultFulmiMessages message : messages)
                        f.set(message.getPath(), message.getDefaultMessage());
                    f.save();
                })
                .build();
    }

}
