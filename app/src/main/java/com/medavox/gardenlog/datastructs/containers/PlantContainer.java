package com.medavox.gardenlog.datastructs.containers;

import android.location.Location;

import com.medavox.gardenlog.datastructs.flora.Plant;

import java.util.Set;

/**
 * @author Adam Howard on 16/12/2016.
 */

public abstract class PlantContainer {
    private Set<Plant> plants;
    public Set<Plant> getPlants() {
        return plants;
    }
    public abstract Location getContainerLocation();
}
