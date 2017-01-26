package com.medavox.gardenlog.datastructs;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * @author Adam Howard
 * @date 13/12/2016
 */

public class Weather extends RealmObject {
    @Required
    private long timestamp;
    private short intensity;

    @Required
    private Type weatherType;

    public enum Type {
        RAINING,
        CLOUDY,
        SUNNY,
        WINDY,
        HAIL,
        SLEET,
        SNOW
    }
}
