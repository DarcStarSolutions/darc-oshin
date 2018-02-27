package org.darcstarsolutions.tools.darcoshin.utils

import org.darcstarsolutions.tools.darcoshin.PlatformSpecification
import org.darcstarsolutions.tools.darcoshin.utils.configurations.PlatformSpecificationDeterminationServiceTestConfiguration
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

import static org.assertj.core.api.Assertions.assertThat

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PlatformSpecificationDeterminationServiceTestConfiguration.class)
class PlatformSpecificationDeterminationServiceTest {

    @Autowired
    PlatformSpecificationDeterminationService platformSpecificationDeterminationService

    @Autowired
    PlatformSpecification.Platform platform

    @Test
    void testExistence() {
        assertThat(platformSpecificationDeterminationService) isNotNull()
        assertThat(platform).isNotNull()
    }

    @Test
    void determinePlatformSpecification() {
    }

    @Test
    void determinePlatform() {
        PlatformSpecification.Platform platform1 = platformSpecificationDeterminationService.determinePlatform()
        assertThat(platform1).isEqualTo(platform)
    }

    @Test
    void determinePlatformFamily() {
    }

    @Test
    void determinePlatformArchitecture() {
    }
}