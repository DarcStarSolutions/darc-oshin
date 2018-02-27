package org.darcstarsolutions.tools.darcoshin.utils.configurations

import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.Platform
import org.darcstarsolutions.tools.darcoshin.utils.PlatformSpecificationDeterminationService
import org.darcstarsolutions.tools.darcoshin.utils.PlatformSpecificationDeterminationServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile

@TestConfiguration
class PlatformSpecificationDeterminationServiceTestConfiguration {

    @Bean
    PlatformSpecificationDeterminationService platformSpecificationDeterminationService() {
        return new PlatformSpecificationDeterminationServiceImpl()
    }

    @Bean
    @Profile("linux")
    Platform linuxPlatform() {
        return Platform.LINUX
    }

    @Bean
    @ConditionalOnMissingBean
    Platform defaultPlatform() {
        return Platform.LINUX
    }

    @Bean
    @Profile("windows")
    Platform windowsPlatform() {
        return Platform.WINDOWS
    }
}
