package com.listek.bookstore.models;

public enum CoverType {
    HardCover,
    SoftCover;

    public static CoverType fromShort(Short x) {
        switch(x) {
            case 0:
                return HardCover;
            case 1:
                return SoftCover;
        }
        return null;
    }
}
