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
public class Plant extends RealmObject {

    @Required
    private String scientificName;

    private RealmList<CommonName> commonNames;

    @Nullable
    private String variety;

    private PlantContainer containedIn;

    //needs to be a string instread of an enumm, because Realm doesn't support enums
    private String type;

    public Type getType() {
        return Type.valueOf(type);
    }

    public enum Type {
        TREE,
        PLANT,
        BUSH,
    }

    //todo: enum of type of plant: tree, bush etc

    //todo:
    //private Image picture;
    /**Any//all of the following picture (whichever are applicable)
     * picture of seeds
     * picture of seedling
     * picture of adult plant
     * picture of elderly plant when it has finished/needs removing
     * picture of crop (if any - fruit, seed, root etc)*/
}
