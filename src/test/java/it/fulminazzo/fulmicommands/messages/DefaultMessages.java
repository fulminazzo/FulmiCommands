package it.fulminazzo.fulmicommands.messages;

import it.fulminazzo.fulmicommands.FulmiMessagesPlugin;
import it.fulminazzo.fulmicommands.MockMessagePlugin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public enum DefaultMessages implements DefaultFulmiMessages {
    PREFIX("prefix", "FulmiCommands >> "),

    GREETING("greeting", "Hello, world!"),

    ;

    private final String path;
    private final String defaultMessage;

    @Override
    public @NotNull String prefix() {
        return PREFIX.getMessage();
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
