package it.fulminazzo.fulmicommands.configuration

import it.fulminazzo.yamlparser.utils.FileUtils
import spock.lang.Specification

class ConfiguratorTest extends Specification {

    private static final File PLUGIN_DIRECTORY = new File('build/resources/test')

    def 'test that configurator loads existing file'() {
        given:
        def configurator = new Configurator()
                .pluginDirectory(PLUGIN_DIRECTORY)
                .name('existing')
                .type(ConfigurationType.TOML)

        and:
        def file = new File(PLUGIN_DIRECTORY, 'existing.toml')
        if (file.exists()) file.delete()
        FileUtils.createNewFile(file)
        file.write('hello = "world"')

        when:
        def config = configurator.build()

        then:
        config.getString('hello') == 'world'
    }

    def 'test that configurator loads non_existing file from jar'() {
        given:
        def configurator = Spy(Configurator)
                .pluginDirectory(PLUGIN_DIRECTORY)
                .name('non_existing_jar')
                .type(ConfigurationType.TOML)
        configurator.getJarResource() >> Optional.of(new ByteArrayInputStream('hello = "world"'.bytes))

        when:
        def config = configurator.build()

        then:
        config.getString('hello') == 'world'
    }

    def 'test that configurator loads non_existing_function file and runs setup function'() {
        given:
        def configurator = new Configurator()
                .pluginDirectory(PLUGIN_DIRECTORY)
                .name('non_existing_function')
                .type(ConfigurationType.TOML)
                .onCreated {
                    it.set('hello', 'world')
                    it.save()
                }

        when:
        def config = configurator.build()

        then:
        config.getString('hello') == 'world'
    }

    def 'test that configurator loads non_existing file'() {
        given:
        def configurator = new Configurator()
                .pluginDirectory(PLUGIN_DIRECTORY)
                .name('non_existing')
                .type(ConfigurationType.TOML)

        and:
        def file = new File(PLUGIN_DIRECTORY, 'non_existing.toml')

        when:
        def config = configurator.build()
        config.set('hello', 'world')
        config.save()

        then:
        file.readLines() == ['hello = "world"']
    }

    def 'test that configurator throws on error file'() {
        given:
        SpyStatic(FileUtils)
        FileUtils.createNewFile(_ as File) >> {
            throw new IOException('Caught exception')
        }

        and:
        def configurator = new Configurator()
                .pluginDirectory(PLUGIN_DIRECTORY)
                .name('throw')

        when:
        configurator.build()

        then:
        thrown(ConfigurationException)
    }

    def 'test that configurator throws if missing field'() {
        when:
        new Configurator()
                .pluginDirectory(pluginDirectory)
                .name(name)
                .type(type)
                .build()

        then:
        thrown(ConfigurationException)

        where:
        pluginDirectory                  | name     | type
        null                             | 'config' | ConfigurationType.YAML
        new File('build/resources/test') | null     | ConfigurationType.YAML
        new File('build/resources/test') | 'config' | null
    }

}
