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
public class ClubsFragment extends Fragment {

    public ClubsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.nHOP), getString(R.string.dHOP), R.drawable.clubs_hop));
        places.add(new Place(getString(R.string.nBlackout), getString(R.string.dBlackout), R.drawable.club_blackout));
        places.add(new Place(getString(R.string.nDuplay), getString(R.string.dDuplay), R.drawable.club_duplay));
        places.add(new Place(getString(R.string.nFBar), getString(R.string.dFBar), R.drawable.club_f_bar));
        places.add(new Place(getString(R.string.nWTF), getString(R.string.dWTF), R.drawable.club_wtf));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}
