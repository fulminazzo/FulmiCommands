package it.fulminazzo.fulmicommands;

import it.fulminazzo.fulmicommands.configuration.ConfigurationException;
import it.fulminazzo.yamlparser.configuration.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MockMessagePlugin extends MockPlugin implements FulmiMessagesPlugin {
    private @Nullable FileConfiguration messages;

    @Override
    public @NotNull FileConfiguration getMessages() {
        if (messages == null) throw FulmiException.configurationNotLoaded("messages.yml");
        return messages;
    }

    @Override
    public @NotNull FileConfiguration setupMessages() throws ConfigurationException {
        messages = FulmiMessagesPlugin.super.setupMessages();
        return messages;
    }


}
