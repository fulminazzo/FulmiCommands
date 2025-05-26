package it.fulminazzo.fulmicommands.messages;

import it.fulminazzo.fulmicommands.FulmiMessagesPlugin;
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
        if (message == null) message = fallbackMessage();
        return message
                .replace("<prefix>", prefix())
                .replace("<path>", path);
    }

    /**
     * Gets the messages prefix.
     *
     * @return the prefix
     */
    @NotNull String prefix();

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
    @NotNull String fallbackMessage();

    /**
     * Gets a plugin that supports {@link FileConfiguration} for messages.
     *
     * @return the plugin
     */
    @NotNull FulmiMessagesPlugin getPlugin();

}
