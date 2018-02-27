package org.darcstarsolutions.tools.darcoshin.utils;

import org.darcstarsolutions.tools.darcoshin.PlatformSpecification;

public interface PlatformSpecificationDeterminationService {


    PlatformSpecification determinePlatformSpecification();

    PlatformSpecification.Platform determinePlatform();

    PlatformSpecification.PlatformFamily determinePlatformFamily();

    PlatformSpecification.PlatformArchitecture determinePlatformArchitecture();
}
