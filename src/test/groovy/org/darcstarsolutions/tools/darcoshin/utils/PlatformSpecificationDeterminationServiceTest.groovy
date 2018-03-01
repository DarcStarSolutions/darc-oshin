package org.darcstarsolutions.tools.darcoshin.utils

import org.darcstarsolutions.tools.darcoshin.PlatformSpecification
import org.darcstarsolutions.tools.darcoshin.utils.configurations.PlatformSpecificationDeterminationServiceTestConfiguration
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

import static org.assertj.core.api.Assertions.assertThat

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PlatformSpecificationDeterminationServiceTestConfiguration.class)
class PlatformSpecificationDeterminationServiceTest {

    static Logger LOGGER = LoggerFactory.getLogger(PlatformSpecificationDeterminationServiceTest.class)

    @Autowired
    Environment environment

    @Autowired
    PlatformSpecificationDeterminationService platformSpecificationDeterminationService

    @Autowired
    PlatformSpecification.PlatformType platformType

    @Autowired
    PlatformSpecification.PlatformArchitecture platformArchitecture

    @Autowired
    PlatformSpecification.PlatformFamily platformFamily

    @Autowired
    PlatformSpecification platformSpecification

    @Test
    void testExistence() {
        assertThat(environment).isNotNull()
        LOGGER.debug("Active Profiles: $environment.activeProfiles")
        assertThat(platformSpecificationDeterminationService).isNotNull()
        assertThat(platformType).isNotNull()
        LOGGER.info("Platform type defined by environment: ${platformType}")
        assertThat(platformFamily).isNotNull()
        LOGGER.info("Platform family defined by environment: ${platformFamily}")
        assertThat(platformArchitecture).isNotNull()
        LOGGER.info("Platform architecture defined by environment: ${platformArchitecture}")
        assertThat(platformSpecification).isNotNull()
        LOGGER.info("Platform specification defined by environment: ${platformSpecification}")


    }

    @Test
    void testDeterminePlatformSpecification() {
        PlatformSpecification platformSpecification1 = platformSpecificationDeterminationService.determinePlatformSpecification()
        assertThat(platformSpecification1).isNotNull()
        assertThat(platformSpecification1).isEqualTo(platformSpecification)
    }

    @Test
    void testDeterminePlatformType() {
        PlatformSpecification.PlatformType platformType1 = platformSpecificationDeterminationService.determinePlatformType()
        assertThat(platformType1).isNotNull()
        assertThat(platformType1).isEqualTo(platformType)
    }

    @Test
    void testDeterminePlatformFamily() {
        PlatformSpecification.PlatformFamily platformFamily1 = platformSpecificationDeterminationService.determinePlatformFamily()
        assertThat(platformFamily1).isNotNull()
        assertThat(platformFamily1).isEqualTo(platformFamily)
    }

    @Test
    void testDeterminePlatformArchitecture() {
        PlatformSpecification.PlatformArchitecture platformArchitecture1 = platformSpecificationDeterminationService.determinePlatformArchitecture()
        assertThat(platformArchitecture1).isNotNull()
        assertThat(platformArchitecture1).isEqualTo(platformArchitecture)
    }
}