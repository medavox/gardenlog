package com.medavox.gardenlog.datastructs;

/**
 * @author Adam Howard on 13/12/2016.
 */

public class GardeningAction {
    /**what action was carried out:
     * weeding
     * planting seed
     * transplanting seedlings
     * moving mature plants
     * harvesting crop
     * collecting seeds
     * pruning leaves
     * removing finished plants
     * deadheading
     * cutting back to soil
     * propagation, different types
     */

    /**
     * @author Adam Howard
     * @date 13/12/2016
     */

    public enum Type {
        WEEDING,
        WATERING,
        PLANT_SEED,
        TRANSPLANT_SEEDLINGS,
        PRUNING,
        PULL_OUT_PLANTS,
        TURNING_SOIL,
        HARVESTING_PRODUCE,
        PROPAGATING,//has subtypes
        /**what action was carried out:
         * weeding
         * planting seed
         * transplanting seedlings
         * moving mature plants
         * harvesting crop
         * collecting seeds
         * pruning leaves
         * removing finished plants
         * deadheading
         * cutting back to soil
         * propagation, different types (cuttings, seed, bulb, ...)
         * turning over beds
         * adding stuff to soil (compost, fertiliser, water????)
         * mixing compost
         *
         */

    }
}
