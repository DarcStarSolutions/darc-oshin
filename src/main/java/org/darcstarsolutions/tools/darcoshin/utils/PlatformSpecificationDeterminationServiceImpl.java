package org.darcstarsolutions.tools.darcoshin.utils;

import com.sun.jna.Platform;
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification;
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture;
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformFamily;
import org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformType;

import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture.BIT_32;
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformArchitecture.BIT_64;
import static org.darcstarsolutions.tools.darcoshin.PlatformSpecification.PlatformType.*;

public class PlatformSpecificationDeterminationServiceImpl implements PlatformSpecificationDeterminationService {

    public PlatformSpecificationDeterminationServiceImpl() {

    }

    @Override
    public PlatformSpecification determinePlatformSpecification() {
        PlatformFamily platformFamily = this.determinePlatformFamily();
        PlatformType platformType = this.determinePlatformType();
        PlatformArchitecture platformArchitecture = this.determinePlatformArchitecture();
        return new PlatformSpecification(platformFamily, platformType, platformArchitecture);
    }

    @Override
    public PlatformType determinePlatformType() {
        PlatformType platformType;
        switch (Platform.getOSType()) {
            case Platform.LINUX:
                platformType = LINUX;
                break;
            case Platform.ANDROID:
                platformType = ANDROID;
                break;
            case Platform.WINDOWS:
                platformType = WINDOWS;
                break;
            case Platform.MAC:
                platformType = MAC_OSX;
                break;
                
            default:
                platformType = UNKNOWN;
        }
        return platformType;
    }

    @Override
    public PlatformFamily determinePlatformFamily() {
        return null;
    }

    @Override
    public PlatformArchitecture determinePlatformArchitecture() {
        PlatformArchitecture platformArchitecture;
        if (Platform.is64Bit()) {
            platformArchitecture = BIT_64;
        } else {
            platformArchitecture = BIT_32;
        }
        return platformArchitecture;
    }


}
