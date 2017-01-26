package com.medavox.gardenlog.datastructs.flora;

/**
 * @author adam howard on 13/12/2016.
 */

import android.support.annotation.Nullable;

import com.medavox.gardenlog.datastructs.PlantContainer;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**Data structure of containing info about a plant being grown*/
public abstract class Plant extends RealmObject {

    @Required
    private String scientificName;

    private RealmList<CommonName> commonNames;

    @Nullable
    private String variety;

    private PlantContainer containedIn;

    //todo:
    //private Image picture;
    /**Any//all of the following picture (whichever are applicable)
     * picture of seeds
     * picture of seedling
     * picture of adult plant
     * picture of elderly plant when it has finished/needs removing
     * picture of crop (if any - fruit, seed, root etc)*/
}
