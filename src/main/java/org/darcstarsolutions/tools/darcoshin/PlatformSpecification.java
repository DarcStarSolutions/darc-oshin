package org.darcstarsolutions.tools.darcoshin;

public class PlatformSpecification {

    public static final PlatformSpecification UNKNOWN = new PlatformSpecification(PlatformFamily.UNKNOWN, PlatformType.UNKNOWN, PlatformArchitecture.UNKNOWN);

    private PlatformFamily platformFamily;
    private PlatformType platformType;
    private PlatformArchitecture architecture;

    public PlatformSpecification(PlatformFamily platformFamily, PlatformType platformType, PlatformArchitecture architecture) {
        this.platformFamily = platformFamily;
        this.platformType = platformType;
        this.architecture = architecture;
    }

    public PlatformFamily getPlatformFamily() {
        return platformFamily;
    }

    public PlatformType getPlatformType() {
        return platformType;
    }


    public PlatformArchitecture getArchitecture() {
        return architecture;
    }


    public enum PlatformFamily {
        UNKNOWN,
        MAC,
        LINUX,
        UNIX,
        WINDOWS;

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public enum PlatformType {
        UNKNOWN,
        /**
         * Microsoft Windows
         */
        WINDOWS,
        WINDOWS_CE,
        /**
         * A flavor of Linux
         */
        LINUX,
        ANDROID,
        /**
         * macOS (OS X)
         */
        MACOSX,
        /**
         * Solaris (SunOS)
         */
        SOLARIS,
        /**
         * FreeBSD
         */
        FREE_BSD,
        /**
         * OpenBSD
         */
        OPEN_BSD,

        NET_BSD,
        AIX,
        GNU,
        KFREE_BSD;

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public enum PlatformArchitecture {

        BIT_32,

        BIT_64,

        UNKNOWN

    }
}
