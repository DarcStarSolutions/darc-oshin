package org.darcstarsolutions.tools.darcoshin.utils.configurations

import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture
import org.darcstarsolutions.tools.darcoshin.utils.PlatformSpecificationDeterminationService
import org.darcstarsolutions.tools.darcoshin.utils.PlatformSpecificationDeterminationServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile

import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture.BIT_32
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture.BIT_64
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformType
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformType.LINUX
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformType.WINDOWS

@TestConfiguration
class PlatformSpecificationDeterminationServiceTestConfiguration {

    @Bean
    PlatformSpecificationDeterminationService platformSpecificationDeterminationService() {
        return new PlatformSpecificationDeterminationServiceImpl()
    }

    @Bean
    @Profile("linux")
    PlatformType linuxPlatform() {
        return LINUX
    }

    @Bean
    @Profile("windows")
    PlatformType windowsPlatform() {
        return WINDOWS
    }

    @Bean
    @ConditionalOnMissingBean
    PlatformType defaultPlatform() {
        return LINUX
    }

    @Bean
    @ConditionalOnMissingBean
    PlatformArchitecture defaultPlatformArchitecture() {
        return BIT_64
    }

    @Bean
    @Profile("32-bit")
    PlatformArchitecture bit32PlatformArchitecture() {
        return BIT_32
    }

    @Bean
    @Profile("64-bit")
    PlatformArchitecture bit64PlatformArchitecture() {
        return BIT_64
    }

}
