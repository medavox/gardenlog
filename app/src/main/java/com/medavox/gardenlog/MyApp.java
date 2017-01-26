package com.medavox.gardenlog;

import android.app.Application;

import io.realm.Realm;

/**
 * @author Adam Howard
 * @date 25/01/2017
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Realm. Should only be done once when the application starts.
        Realm.init(this);
    }
}
