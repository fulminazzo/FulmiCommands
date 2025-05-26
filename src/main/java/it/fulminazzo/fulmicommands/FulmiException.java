package it.fulminazzo.fulmicommands;

import org.jetbrains.annotations.NotNull;

/**
 * A general exception thrown by {@link FulmiPlugin}.
 */
public final class FulmiException extends RuntimeException {

    /**
     * Instantiates a new Fulmi exception.
     *
     * @param message the message
     */
    FulmiException(final @NotNull String message) {
        super(message);
    }


    /**
     * Returns a new FulmiException with message:
     * <i>The configuration file "%configuration%" has not been loaded yet</i>
     *
     * @param configuration the configuration
     * @return the fulmi exception
     */
    public static @NotNull FulmiException configurationNotLoaded(final @NotNull String configuration) {
        return new FulmiException(String.format("The configuration file \"%s\" has not been loaded yet", configuration));
    }

}
