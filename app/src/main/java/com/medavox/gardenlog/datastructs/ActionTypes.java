package com.medavox.gardenlog.datastructs;

/**
 @author Adam Howard
 @date 24/01/2017
 */

public enum ActionTypes {
    WEEDING ("weeding"),
    PLANTING_SEED ("planting seed"),
    TRANSPLANTING_SEEDLINGS ("transplanting seedlings"),
    MOVING_MATURE_PLANTS ("moving mature plants"),
    HARVESTING_CROP ("harvesting crop"),
    COLLECTING_SEEDS ("collecting seeds"),
    PRUNING_LEAVES ("pruning leaves"),
    REMOVING_FINISHED_PLANTS ("removing finished plants"),
    DEADHEADING ("deadheading"),
    CUTTING_BACK_TO_SOIL ("cutting back to soil"),
    PROPAGATION_DIFFERENT_TYPES ("propagation, different types");

    private String name;

    ActionTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
