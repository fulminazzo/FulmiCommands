package it.fulminazzo.fulmicommands

import it.fulminazzo.fulmicommands.messages.DefaultMessages
import it.fulminazzo.yamlparser.configuration.FileConfiguration
import spock.lang.Specification

class FulmiPluginTest extends Specification {

    def 'test that setupConfiguration does not throw'() {
        given:
        def plugin = new MockPlugin()

        when:
        plugin.setupConfiguration()

        then:
        plugin.getConfiguration() != null
    }

    def 'test that getConfiguration without setup throws'() {
        given:
        def plugin = new MockMessagePlugin()

        when:
        plugin.getConfiguration()

        then:
        thrown(FulmiException)
    }

    def 'test that setupMessages stores default messages in the config file'() {
        given:
        def plugin = new MockMessagePlugin()

        and:
        def expected = DefaultMessages.values().collect { it.defaultMessage }

        when:
        plugin.setupMessages(DefaultMessages.values())

        and:
        def file = new File(plugin.pluginDirectory, 'messages.yml')
        def messages = FileConfiguration.newConfiguration(file)

        and:
        def actual = DefaultMessages.values().collect { messages.getString(it.path) }

        then:
        actual == expected
    }

    def 'test that setupMessages does not throw'() {
        given:
        def plugin = new MockMessagePlugin()

        when:
        plugin.setupMessages()

        then:
        plugin.getMessages() != null
    }

    def 'test that getMessages without setup throws'() {
        given:
        def plugin = new MockMessagePlugin()

        when:
        plugin.getMessages()

        then:
        thrown(FulmiException)
    }

}
