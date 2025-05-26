package it.fulminazzo.fulmicommands

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

    def 'test that setupMessages does not throw'() {
        given:
        def plugin = new MockMessagePlugin()

        when:
        plugin.setupMessages()

        then:
        plugin.getMessages() != null
    }

}
