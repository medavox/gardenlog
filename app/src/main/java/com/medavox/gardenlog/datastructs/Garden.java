package com.medavox.gardenlog.datastructs;

import android.location.Location;
import android.support.annotation.Nullable;

import com.medavox.gardenlog.datastructs.flora.Plant;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * @author Adam Howard on 16/12/2016.
 */

/**A Garden, which can contain {@link PlantContainer}s and {@link Plant}s in them, or out of them.*/
public class Garden extends RealmObject {

    private String name;

    //for storing enums, use a string http://stackoverflow.com/a/229919
    //enum -> String: enum.name();
    //String -> enum: enum.valueOf(string)


    //"biome TEXT",//a simpler alternative to the vaguefied location info


    /**optional picture or some kind of vector format for floorplans*/
    @Nullable
    private byte[] areaPlan;

    @Nullable
    private String areaPlanMimeType;

    /**Optional. although the following would be useful:
     approximate latitude,
     rough distance from coastline,
     and whether that is an easterly or westerly coast (or north/south)*/
    @Nullable
    private Location location;

    private RealmList<PlantContainer> gardenContainers;

    private RealmList<Gardener> associatedMembers;

}
