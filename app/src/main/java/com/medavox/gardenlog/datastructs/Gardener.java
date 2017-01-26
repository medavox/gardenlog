package com.medavox.gardenlog.datastructs;

/**
 * @author Adam Howard
 * @date 16/12/2016.
 */

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**Represents a person who gardens.*/
public class Gardener extends RealmObject {
    @Required
    private String name;
    //todo:decide whether email is optional
    private String email;
    @Nullable
    private byte[] userImage;
    @Nullable
    private String imageMimeType;
}
