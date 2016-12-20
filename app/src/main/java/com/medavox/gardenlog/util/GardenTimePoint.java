package com.medavox.gardenlog.util;

import android.support.annotation.IntRange;

/**
 * @author Adam Howard
 * @date 20/12/2016
 */

public class GardenTimePoint {
    public static enum
    public static GardenTimePoint AFTER_LAST_FROST;
    public static GardenTimePoint BEFORE_FIRST_FROST;

    @IntRange(from=-4, to=366)
    private int dayOfYear;
}
