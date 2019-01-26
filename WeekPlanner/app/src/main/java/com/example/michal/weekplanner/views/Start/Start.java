package com.example.michal.weekplanner.views.Start;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.michal.weekplanner.R;
import com.example.michal.weekplanner.views.Start.GoogleMapsApi.View_GPS;


public class Start extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.start, container, false);

        Button button = rootView.findViewById(R.id.gpsstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), View_GPS.class);
                startActivity(myIntent);
            }
        });
        Button button1 = rootView.findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), Biometr.class);
                startActivity(myIntent);
            }
        });

        return rootView;
    }



}


