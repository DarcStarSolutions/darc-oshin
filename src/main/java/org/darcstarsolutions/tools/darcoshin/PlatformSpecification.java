package org.darcstarsolutions.tools.darcoshin;

public class PlatformSpecification {

    public static final PlatformSpecification UNKNOWN = new PlatformSpecification(PlatformFamily.UNKNOWN, Platform.UNKNOWN, PlatformArchitecture.UNKNOWN);
    private PlatformFamily platformFamily;
    private Platform platform;
    private PlatformArchitecture architecture;

    public PlatformSpecification(final PlatformFamily platformFamily, final Platform platform, final PlatformArchitecture architecture) {
        this.platformFamily = platformFamily;
        this.platform = platform;
        this.architecture = architecture;
    }

    public PlatformFamily getPlatformFamily() {
        return platformFamily;
    }

    public Platform getPlatform() {
        return platform;
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

    public enum Platform {
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
