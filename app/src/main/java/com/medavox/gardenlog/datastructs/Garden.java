package com.medavox.gardenlog.datastructs;

import android.location.Location;
import android.support.annotation.Nullable;

import com.medavox.gardenlog.datastructs.flora.Plant;

import java.util.Collection;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * @author Adam Howard on 16/12/2016.
 */

/**A Garden, which can contain {@link PlantContainer}s and {@link Plant}s in them, or out of them.*/
public class Garden extends RealmObject {

    //todo: avoid this!
    public Garden() {

    }

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
    private double latitude;
    private double longitude;

    private RealmList<PlantContainer> gardenContainers;

    private RealmList<Gardener> associatedMembers;


    public Garden(String name) {
        this.name = name;
    }

    @Nullable
    public byte[] getAreaPlan() {
        return areaPlan;
    }

    public void setLocation(double lat, double lon){
        this.longitude = lon;
        this.latitude = lat;
    }

    public void setAreaPlan(@Nullable byte[] areaPlan, @Nullable String mimeType) {
        this.areaPlan = areaPlan;
        this.areaPlanMimeType = mimeType;
    }

    /*
    public void addGardener(Gardener g) {
        associatedMembers.add(g);
    }

    public void addGardeners(Gardener[] gardeners) {
        for(Gardener g : gardeners) {
            addGardener(g);
        }
    }

    public void addGardeners(Collection<Gardener> gardeners) {
        for(Gardener g : gardeners) {
            addGardener(g);
        }
    }*/

    @Nullable
    public String getAreaPlanMimeType() {
        return areaPlanMimeType;
    }

    /**Use this to directly modify the list of associated gardeners*/
    public RealmList<Gardener> getAssociatedMembers() {
        return associatedMembers;
    }

    public RealmList<PlantContainer> getGardenContainers() {
        return gardenContainers;
    }
/*TODO; reimplement using lat and long numbers
    @Nullable
    public Location getLocation() {
        return location;
    }
*/
    public String getName() {
        return name;
    }
}
