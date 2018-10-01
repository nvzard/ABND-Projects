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
public class SitesFragment extends Fragment {


    public SitesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.nHawaMahal), getString(R.string.dHawaMahal), R.drawable.site_hawa_mahal));
        places.add(new Place(getString(R.string.nCityPalace), getString(R.string.dCityPalace), R.drawable.site_city_palace));
        places.add(new Place(getString(R.string.nAmberFort), getString(R.string.dAmberFort), R.drawable.site_amer_fort));
        places.add(new Place(getString(R.string.nNahargarhFort), getString(R.string.dNahargarhFort), R.drawable.site_nahargarh_fort));
        places.add(new Place(getString(R.string.nAlbertHall), getString(R.string.dAlbertHall), R.drawable.site_albert_hall_museum));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}
