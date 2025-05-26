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

    def 'test that getConfiguration without setup throws'() {
        given:
        def plugin = new MockMessagePlugin()

        when:
        plugin.getConfiguration()

        then:
        thrown(FulmiException)
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
