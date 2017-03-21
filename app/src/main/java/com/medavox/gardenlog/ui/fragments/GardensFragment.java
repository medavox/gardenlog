package com.medavox.gardenlog.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.medavox.gardenlog.Scaffold;
import com.medavox.gardenlog.datastructs.Garden;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * @author Adam Howard
 * @date 19/12/2016
 */

/**List of gardens this user (gardener) is subscribed to*/
public class GardensFragment extends RealmListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Scaffold.fakeItUp(realm);
        //create realm query
        RealmResults<Garden> gardens = realm.where(Garden.class).findAll();
        //create realm base adapter using realm query
        RealmBaseAdapter<Garden> adapter = new RealmBaseAdapter<Garden>(getContext(), gardens) {
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                Garden garden = getItem(i);
                TextView tv = new TextView(getContext());
                tv.setText(garden.getName());
                return tv;
            }
        };

        //set the adapter to this list fragment
        setListAdapter(adapter);
    }

    public void onPause() {
        super.onPause();
    }

}
