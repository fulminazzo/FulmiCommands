package it.fulminazzo.fulmicommands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public enum Messages implements FulmiMessages {
    PREFIX("prefix"),

    GREETING("greeting"),
    ;

    private final String path;

    @Override
    public @NotNull String getPrefix() {
        return "FulmiCommands >> ";
    }

    @Override
    public @NotNull String getFallbackMessage() {
        return "Invalid configuration file detected, could not find path: %path%";
    }

    @Override
    public @NotNull FulmiMessagesPlugin getPlugin() {
        return MockMessagePlugin.getPlugin();
    }

}
