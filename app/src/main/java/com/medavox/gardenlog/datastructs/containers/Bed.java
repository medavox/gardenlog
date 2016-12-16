package com.medavox.gardenlog.datastructs.containers;

/**
 * @author Adam Howard on 16/12/2016.
 */

import android.location.Location;

import com.medavox.gardenlog.datastructs.containers.PlantContainer;
import com.medavox.gardenlog.datastructs.flora.Plant;

/**A garden bed, possibly containing {@link Plant}s*/
public class Bed extends PlantContainer {

    @Override
    public Location getContainerLocation() {
        return null;
    }
}
