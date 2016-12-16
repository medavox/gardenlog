package com.medavox.gardenlog.datastructs;

import android.location.Location;

import com.medavox.gardenlog.datastructs.containers.Bed;
import com.medavox.gardenlog.datastructs.flora.Plant;

import java.util.Set;

/**
 * @author Adam Howard on 16/12/2016.
 */

/**A Garden, which can contain {@link Bed}s and {@link Plant}s in them, or out of them.*/
public class Garden {
    private Location location;
    private Set<Bed> gardenBeds;
    private Set<Bed> plants;

    private Set<Gardener> associatedMembers;

}
