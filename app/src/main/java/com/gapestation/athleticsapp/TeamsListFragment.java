package com.gapestation.athleticsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TeamsListFragment extends Fragment implements View.OnClickListener {
    public Button guysLacrosse;
    public Button football;
    public Button guysBasketball;
    public Button guysSoccer;
    public Button girlsBasketball;
    public static String buttonClicked;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup view, Bundle bundle) {
        super.onCreateView(inflater, view, bundle);

        final View rootView = inflater.inflate(R.layout.fragment_teams_list, view, false);

        guysLacrosse = (Button)rootView.findViewById(R.id.lacrosse);
        football = (Button)rootView.findViewById(R.id.football);
        guysBasketball = (Button)rootView.findViewById(R.id.basketball);
        guysSoccer = (Button)rootView.findViewById(R.id.baseball);
        girlsBasketball = (Button)rootView.findViewById(R.id.girls_basketball);

        guysLacrosse.setOnClickListener(this);
        football.setOnClickListener(this);
        guysBasketball.setOnClickListener(this);
        guysSoccer.setOnClickListener(this);
        girlsBasketball.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        buttonClicked = b.getText().toString();
        System.out.println(buttonClicked);
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.content_frame, new TeamFragment());
        fr.commit();
    }
}
