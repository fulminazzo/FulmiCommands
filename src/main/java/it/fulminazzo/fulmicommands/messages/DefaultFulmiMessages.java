package it.fulminazzo.fulmicommands.messages;

import org.jetbrains.annotations.NotNull;

/**
 * An implementation of {@link FulmiMessages} that provides a default fallback message.
 */
public interface DefaultFulmiMessages extends FulmiMessages {

    /**
     * Gets the fallback message associated with the path.
     *
     * @return the default message
     */
    @NotNull String getDefaultMessage();

}
