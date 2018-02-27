package org.darcstarsolutions.tools.darcoshin.utils;

import com.sun.jna.Platform;
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification;

public class PlatformSpecificationDeterminationServiceImpl implements PlatformSpecificationDeterminationService {

    public PlatformSpecificationDeterminationServiceImpl() {

    }

    @Override
    public PlatformSpecification determinePlatformSpecification() {
        PlatformSpecification.PlatformFamily platformFamily = this.determinePlatformFamily();
        PlatformSpecification.Platform platform = this.determinePlatform();
        PlatformSpecification.PlatformArchitecture platformArchitecture = this.determinePlatformArchitecture();
        return new PlatformSpecification(platformFamily, platform, platformArchitecture);
    }

    @Override
    public PlatformSpecification.Platform determinePlatform() {
        PlatformSpecification.Platform platform = PlatformSpecification.Platform.UNKNOWN;
        switch (Platform.getOSType()) {
            case Platform.LINUX:
                platform = PlatformSpecification.Platform.LINUX;
                break;
            case Platform.ANDROID:
                platform = PlatformSpecification.Platform.ANDROID;
                break;
            case Platform.WINDOWS:
                platform = PlatformSpecification.Platform.WINDOWS;
                break;

            default:
                platform = PlatformSpecification.Platform.UNKNOWN;
        }
        return platform;
    }

    @Override
    public PlatformSpecification.PlatformFamily determinePlatformFamily() {
        return null;
    }

    @Override
    public PlatformSpecification.PlatformArchitecture determinePlatformArchitecture() {
        return null;
    }


}
