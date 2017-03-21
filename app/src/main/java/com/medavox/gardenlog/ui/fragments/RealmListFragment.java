package com.medavox.gardenlog.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medavox.gardenlog.MyApp;
import com.medavox.gardenlog.datastructs.Garden;

import io.realm.Realm;
import io.realm.RealmBaseAdapter;
import io.realm.RealmQuery;

/**
 * @author Adam Howard
 * @date 19/12/2016
 */

/**List of gardens this user (gardener) is subscribed to*/
public class RealmListFragment extends ListFragment {
    Realm realm;

    @Override
    public void onStart() {
        super.onStart();
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(realm != null) {
            realm.close();
            realm = null;
        }
    }
}
