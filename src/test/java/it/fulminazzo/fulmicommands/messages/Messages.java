package it.fulminazzo.fulmicommands.messages;

import it.fulminazzo.fulmicommands.FulmiMessagesPlugin;
import it.fulminazzo.fulmicommands.MockMessagePlugin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public enum Messages implements FulmiMessages {
    NO_PREFIX("no-prefix"),
    PREFIXED("prefixed"),
    NOT_EXISTS("not-exists"),
    ;

    private final String path;

    @Override
    public @NotNull String prefix() {
        return "FulmiCommands >> ";
    }

    @Override
    public @NotNull String fallbackMessage() {
        return "Invalid configuration file detected, could not find path: <path>";
    }

    @Override
    public @NotNull FulmiMessagesPlugin getPlugin() {
        return MockMessagePlugin.getPlugin();
    }

}
