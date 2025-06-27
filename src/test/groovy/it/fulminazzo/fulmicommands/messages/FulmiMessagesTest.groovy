package it.fulminazzo.fulmicommands.messages

import it.fulminazzo.fulmicommands.MockMessagePlugin
import spock.lang.Specification

class FulmiMessagesTest extends Specification {

    void setup() {
        def plugin = new MockMessagePlugin()
        plugin.setupMessages()
        plugin.getMessages().set(Messages.PREFIXED.path, '<prefix> Hello, world!')
        plugin.getMessages().set(Messages.NO_PREFIX.path, 'Hello, friend!')
    }

    def 'test that #message returns #expected'() {
        when:
        def actual = message.getMessage().serialize()

        then:
        actual == expected

        where:
        message             || expected
        Messages.PREFIXED   || Messages.PREFIXED.prefix() + ' Hello, world!'
        Messages.NO_PREFIX  || 'Hello, friend!'
        Messages.NOT_EXISTS || "Invalid configuration file detected, could not find path: $Messages.NOT_EXISTS.path"
    }

}
