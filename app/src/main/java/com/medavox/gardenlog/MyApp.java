package com.medavox.gardenlog;

import android.app.Application;

import io.realm.Realm;

/**
 * @author Adam Howard
 * @date 25/01/2017
 */

public class MyApp extends Application {
    private static Realm realm;
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Realm. Should only be done once when the application starts.
        Realm.init(this);
    }
    public static Realm getRealm() {
        if(realm == null){
            realm = Realm.getDefaultInstance();
        }
        return realm;
    }
}
