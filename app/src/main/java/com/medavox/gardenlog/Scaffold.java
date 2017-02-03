package com.medavox.gardenlog;

/**
 * @author Adam Howard
 * @date 03/02/2017
 */

import com.medavox.gardenlog.datastructs.Garden;

import io.realm.Realm;

/**Simple POJO to host all the fake data we populate the DB with, during construction of the app*/
public class Scaffold {
    public static void fakeItUp(Realm realm) {
        realm.beginTransaction();
        Garden[] gardens = new Garden[4];
        for(int i = 0; i < gardens.length; i++) {
            gardens[i] = realm.createObject(Garden.class);
            //gardens[i].name
        }
        realm.commitTransaction();
    }
}
