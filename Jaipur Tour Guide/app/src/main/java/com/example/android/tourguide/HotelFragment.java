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
public class HotelFragment extends Fragment {

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.nRajputana), getString(R.string.dRajputana), R.drawable.hotel_itc_rajputana));
        places.add(new Place(getString(R.string.nRadisson), getString(R.string.dRadisson), R.drawable.hotel_radisson));
        places.add(new Place(getString(R.string.nRambagh), getString(R.string.dRambagh), R.drawable.hotel_rambagh));
        places.add(new Place(getString(R.string.nLalit), getString(R.string.dLalit), R.drawable.hotel_lalit));
        places.add(new Place(getString(R.string.nMarriott), getString(R.string.dMarriott), R.drawable.hotel_marriott));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

}
