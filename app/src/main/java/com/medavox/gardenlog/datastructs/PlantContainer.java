package com.medavox.gardenlog.datastructs;

import android.location.Location;


import com.medavox.gardenlog.datastructs.flora.Plant;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * @author Adam Howard on 16/12/2016.
 */

public class PlantContainer extends RealmObject {
    private RealmList<Plant> containedPlants;
    private String containerType;


    public Type getType() {
        return Type.valueOf(containerType);
    }

    //todo
    public Location getContainerLocation() {
        return null;
    }

    public enum Type {
        GROUND_BED,
        RAISED_BED,
        PLANT_POT,
        HANGING_BASKET,
        WINDOW_BOX,
        HYDROPONICS_BASKET,
        OTHER
    }
}
