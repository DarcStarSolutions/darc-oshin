package org.darcstarsolutions.tools.darcoshin.utils;

import org.darcstarsolutions.tools.darcoshin.PlatformSpecification;
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture;
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformFamily;
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformType;

public interface PlatformSpecificationDeterminationService {


    PlatformSpecification determinePlatformSpecification();

    PlatformType determinePlatformType();

    PlatformFamily determinePlatformFamily();

    PlatformArchitecture determinePlatformArchitecture();

    PlatformFamily determinePlatformFamily(PlatformType platformType);
}
