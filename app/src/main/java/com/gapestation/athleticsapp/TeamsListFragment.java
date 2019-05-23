package com.gapestation.athleticsapp;

import android.annotation.SuppressLint;
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
    public String buttonClicked;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup view, Bundle bundle) {
        super.onCreateView(inflater, view, bundle);

        final View rootView = inflater.inflate(R.layout.fragment_teams_list, view, false);

        guysLacrosse = (Button)rootView.findViewById(R.id.guysLacrosse);
        football = (Button)rootView.findViewById(R.id.football);
        guysBasketball = (Button)rootView.findViewById(R.id.guysBasketball);
        guysSoccer = (Button)rootView.findViewById(R.id.guysSoccer);

        guysLacrosse.setOnClickListener(this);
        football.setOnClickListener(this);
        guysBasketball.setOnClickListener(this);
        guysSoccer.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        buttonClicked = b.getText().toString();
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.content_frame, new TeamFragment());
        fr.commit();
    }
}
