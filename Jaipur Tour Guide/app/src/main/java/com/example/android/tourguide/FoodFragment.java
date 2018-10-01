package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.nDalBaati), getString(R.string.dDalBaati), R.drawable.food_dal_baati));
        places.add(new Place(getString(R.string.nKachori), getString(R.string.dKachori), R.drawable.food_kachori));
        places.add(new Place(getString(R.string.nGhevar), getString(R.string.dGhevar), R.drawable.food_ghevar));
        places.add(new Place(getString(R.string.nMirchiVada), getString(R.string.dMirchiVada), R.drawable.food_mirchi_vada));
        places.add(new Place(getString(R.string.nThali), getString(R.string.dThali), R.drawable.food_thali));


        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}
