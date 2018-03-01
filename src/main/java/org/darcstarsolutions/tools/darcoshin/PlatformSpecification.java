package org.darcstarsolutions.tools.darcoshin;

import java.util.Objects;

public class PlatformSpecification {

    public static final PlatformSpecification UNKNOWN = new PlatformSpecification(PlatformFamily.UNKNOWN, PlatformType.UNKNOWN, PlatformArchitecture.UNKNOWN);

    private PlatformFamily platformFamily;
    private PlatformType platformType;
    private PlatformArchitecture platformArchitecture;

    public PlatformSpecification(final PlatformFamily platformFamily, final PlatformType platformType, final PlatformArchitecture platformArchitecture) {
        this.platformFamily = platformFamily;
        this.platformType = platformType;
        this.platformArchitecture = platformArchitecture;
    }

    public PlatformFamily getPlatformFamily() {
        return platformFamily;
    }

    public PlatformType getPlatformType() {
        return platformType;
    }


    public PlatformArchitecture getArchitecture() {
        return platformArchitecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlatformSpecification)) return false;
        PlatformSpecification that = (PlatformSpecification) o;
        return platformFamily == that.platformFamily &&
                platformType == that.platformType &&
                platformArchitecture == that.platformArchitecture;
    }

    @Override
    public int hashCode() {

        return Objects.hash(platformFamily, platformType, platformArchitecture);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlatformSpecification{");
        sb.append("platformFamily=").append(platformFamily);
        sb.append(", platformType=").append(platformType);
        sb.append(", platformArchitecture=").append(platformArchitecture);
        sb.append('}');
        return sb.toString();
    }

    public enum PlatformFamily {
        UNKNOWN,
        OSX,
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
        MAC_OSX,
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

        UNKNOWN;

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
