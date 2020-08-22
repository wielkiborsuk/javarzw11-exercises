package com.sda.javarzw11.packagesize;

public enum PackageSize {

    SMALL(1, 20),
    MEDIUM(21, 40),
    LARGE(41, 60),
    EXTRA_LARGE(61, 80),
    HUUUUUUGE(81, 10000);

    int minSize;
    int maxSize;

    PackageSize(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    static PackageSize getPackageSize(int actualSize) {
        for(PackageSize currentSize : PackageSize.values()) {
            if (actualSize >= currentSize.minSize && actualSize <= currentSize.maxSize) {
                return currentSize;
            }
        }

        return null;
    }

}
