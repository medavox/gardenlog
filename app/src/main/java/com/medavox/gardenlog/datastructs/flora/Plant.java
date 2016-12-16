package com.medavox.gardenlog.datastructs.flora;

/**
 * @author adam howard on 13/12/2016.
 */

import android.support.annotation.Nullable;

import java.util.Set;

/**Data structure of containing info about a plant being grown*/
public abstract class Plant {
    private String scientificName;
    private Set<String> commonName;

    @Nullable
    private String variety;

    //private Image picture;

    /**Any of the following picture (whichever are applicable)
     * picture of seeds
     * picture of seedling
     * picture of adult plant
     * picture of elderly plant when it has finished/needs removing
     * picture of crop (if any - fruit, seed, root etc)*/
}
