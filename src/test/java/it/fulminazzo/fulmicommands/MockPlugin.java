package it.fulminazzo.fulmicommands;

import it.fulminazzo.fulmicommands.configuration.ConfigurationException;
import it.fulminazzo.yamlparser.configuration.FileConfiguration;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

@Getter
public class MockPlugin implements FulmiPlugin {
    private final @NotNull File pluginDirectory = new File("build/resources/test");

    private @Nullable FileConfiguration configuration;

    @Override
    public @NotNull FileConfiguration getConfiguration() {
        if (configuration == null) throw FulmiException.configurationNotLoaded("config.yml");
        return configuration;
    }

    @Override
    public @NotNull FileConfiguration setupConfiguration() throws ConfigurationException {
        configuration = FulmiPlugin.super.setupConfiguration();
        return configuration;
    }

}
