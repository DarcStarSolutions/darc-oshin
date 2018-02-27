package org.darcstarsolutions.tools.darcoshin.utils.configurations

import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.Platform
import org.darcstarsolutions.tools.darcoshin.utils.PlatformSpecificationDeterminationService
import org.darcstarsolutions.tools.darcoshin.utils.PlatformSpecificationDeterminationServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class PlatformSpecificationDeterminationServiceTestConfiguration {

    @Bean
    PlatformSpecificationDeterminationService platformSpecificationDeterminationService() {
        return new PlatformSpecificationDeterminationServiceImpl()
    }

    @Bean
    @ConditionalOnProperty(name = "darc-oshin.platform", havingValue = "linux", matchIfMissing = true)
    Platform linux() {
        return Platform.LINUX
    }
}
