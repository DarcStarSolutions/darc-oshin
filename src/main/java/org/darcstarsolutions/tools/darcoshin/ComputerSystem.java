package org.darcstarsolutions.tools.darcoshin;

import org.darcstarsolutions.tools.darcoshin.hardware.Hardware;
import org.darcstarsolutions.tools.darcoshin.software.OperatingSystem;

import java.io.Serializable;

public interface ComputerSystem extends Serializable {

    PlatformSpecification PLATFORM_SPECS = PlatformSpecification.UNKNOWN;

    OperatingSystem OPERATING_SYSTEM = null;

    Hardware HARDWARE = null;


    default PlatformSpecification getPlatformSpecs() {
        return PLATFORM_SPECS;
    }

    default OperatingSystem getOperatingSystem() {
        return OPERATING_SYSTEM;
    }

    default Hardware getHardware() {
        return HARDWARE;
    }

}
