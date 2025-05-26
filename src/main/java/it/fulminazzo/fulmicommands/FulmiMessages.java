package it.fulminazzo.fulmicommands;

import it.fulminazzo.yamlparser.configuration.FileConfiguration;
import org.jetbrains.annotations.NotNull;

/**
 * A collection of utility methods for messages enum.
 */
public interface FulmiMessages {

    /**
     * Gets the message from the <i>messages.yml</i> configuration file.
     *
     * @return the message
     */
    default @NotNull String getMessage() {
        FileConfiguration messages = getPlugin().getMessages();
        String path = getPath();
        String message = messages.getString(path);
        if (message == null) message = getFallbackMessage();
        return message
                .replace("<prefix>", getPrefix())
                .replace("<path>", path);
    }

    /**
     * Gets the messages prefix.
     *
     * @return the prefix
     */
    @NotNull String getPrefix();

    /**
     * Gets the path in the configuration.
     *
     * @return the path
     */
    @NotNull String getPath();

    /**
     * Gets the message in case {@link #getMessage()} is not able to find it from the configuration.
     *
     * @return the fallback message
     */
    @NotNull String getFallbackMessage();

    /**
     * Gets a plugin that supports {@link FileConfiguration} for messages.
     *
     * @return the plugin
     */
    @NotNull FulmiMessagesPlugin getPlugin();

}
