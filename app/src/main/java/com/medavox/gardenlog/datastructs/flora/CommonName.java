package com.medavox.gardenlog.datastructs.flora;

import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * @author Adam Howard
 * @date 25/01/2017
 */

/**Wrapper around Strings to allows them to be used in {@link io.realm.RealmList}s*/
public class CommonName extends RealmObject {
    private String name;
    public String get() {
        return name;
    }
}
