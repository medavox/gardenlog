package com.medavox.gardenlog.util;

import android.support.annotation.IntRange;

/**
 * @author Adam Howard
 * @date 20/12/2016
 */

public class TimeDuration {


    public static enum SpecialDates {
        LAST_FROST,
        FIRST_FROST,
        GROUND_FREEZES
    }

    @IntRange(from=1, to=366)
    private int dayOfYear;
    public TimeDuration()
}
