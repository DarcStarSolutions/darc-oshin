package org.darcstarsolutions.tools.darcoshin.utils.configurations

import org.darcstarsolutions.tools.darcoshin.PlatformSpecification
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformFamily
import org.darcstarsolutions.tools.darcoshin.utils.PlatformSpecificationDeterminationService
import org.darcstarsolutions.tools.darcoshin.utils.PlatformSpecificationDeterminationServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order

import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture.BIT_32
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture.BIT_64
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformType.*
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformType

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
    @Profile("mac-osx")
    PlatformType macOsxPlatform() {
        return MAC_OSX
    }

    @Bean
    @ConditionalOnMissingBean
    @Order(value = Ordered.LOWEST_PRECEDENCE)
    PlatformType defaultPlatform() {
        return LINUX
    }

    @Bean
    @Profile("linux")
    PlatformFamily linuxPlatformFamily() {
        return PlatformFamily.LINUX
    }

    @Bean
    @Profile("windows")
    PlatformFamily windowsPlatformFamily() {
        return PlatformFamily.WINDOWS
    }

    @Bean
    @Profile("mac-osx")
    PlatformFamily macOsxPlatformFamily() {
        return PlatformFamily.OSX
    }

    @Bean
    @ConditionalOnMissingBean
    @Order(value = Ordered.LOWEST_PRECEDENCE)
    PlatformFamily defaultPlatformFamily() {
        return PlatformFamily.LINUX
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

    @Bean
    @Order(value = Ordered.LOWEST_PRECEDENCE)
    @ConditionalOnMissingBean
    PlatformArchitecture defaultPlatformArchitecture() {
        return BIT_64
    }

    @Bean
    @Autowired
    PlatformSpecification platformSpecification(PlatformFamily platformFamily, PlatformType platformType, PlatformArchitecture platformArchitecture) {
        return new PlatformSpecification(platformFamily, platformType, platformArchitecture)

    }
}
